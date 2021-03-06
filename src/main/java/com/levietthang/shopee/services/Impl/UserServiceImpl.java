package com.levietthang.shopee.services.Impl;

import com.levietthang.shopee.constant.Constant;
import com.levietthang.shopee.dto.UserRegisterDTO;
import com.levietthang.shopee.entities.Role;
import com.levietthang.shopee.entities.User;
import com.levietthang.shopee.entities.UserDetails;
import com.levietthang.shopee.model.RegisterStatus;
import com.levietthang.shopee.model.Validator;
import com.levietthang.shopee.repositories.repository.RoleRepository;
import com.levietthang.shopee.repositories.repository.UserDetailsRepository;
import com.levietthang.shopee.repositories.repository.UserRepository;
import com.levietthang.shopee.services.CustomUserService;
import com.levietthang.shopee.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements CustomUserService, Constant {

    private RegisterStatus registerStatus;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> findAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public RegisterStatus createUserAccount(UserRegisterDTO userRegisterDTO) {
        if (!validatorUser(userRegisterDTO).isRegisterStatus()) {
            return validatorUser(userRegisterDTO);
        } else {
            try {
                 userRegisterDTO.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
                 userRegisterDTO.setConfirmPassword(passwordEncoder.encode(userRegisterDTO.getConfirmPassword()));

                 User user = new User();
                 Set<Role> roles = roleService.findRoleByName("USER");
                 UserDetails userDetails = new UserDetails();

                 user.setUsername(userRegisterDTO.getUsername());
                 user.setPassword(userRegisterDTO.getPassword());
                 user.setEnable(true);
                 user.setRoles(roles);
                 user.setEmail(userRegisterDTO.getEmail());
                 User userCreate = userRepository.save(user);

                 userDetails.setUserId(userCreate.getId());
                 userDetails.setName(userRegisterDTO.getName());
                 userDetails.setBirthday(userRegisterDTO.getBirthday());
                 userDetails.setAddress1(userRegisterDTO.getAddress1());
                 userDetails.setAddress2(userRegisterDTO.getAddress2());
                 userDetails.setPhone(userRegisterDTO.getPhone());

                 userDetailsRepository.save(userDetails);
                return new RegisterStatus(true, Constant.REGISTER_SUCCESS);
            } catch (Exception e) {
                e.printStackTrace();
                return new RegisterStatus(false, Constant.REGISTER_FAILED);
            }
        }

    }

    @Override
    public User setAdminRole(User user) {
        Set<Role> roles = roleService.findAll();
        User user1 = userRepository.findUserByUsernameAndId(user.getUsername(), user.getId());
        if (user1 == null) {
            return null;
        }
        user1.setRoles(roles);
        return userRepository.save(user1);
    }

    public RegisterStatus validatorUser(UserRegisterDTO userRegisterDTO) {
        registerStatus = new RegisterStatus();

        if (!Validator.validateEmail(userRegisterDTO.getEmail())) {
            registerStatus.setMessage(Constant.REGISTER_VALIDATE_FAILED_EMAIL);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }
        if (!Validator.validateUsername(userRegisterDTO.getUsername())) {
            registerStatus.setMessage(Constant.REGISTER_VALIDATE_FAILED_USER_NAME);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }

        boolean availableUsername = userRepository.findUserByUsername(userRegisterDTO.getUsername()) == null? true : false;
        if (!availableUsername) {
            registerStatus.setMessage(Constant.REGISTER_EXISTS_USER_NAME);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }
        boolean availableEmail = userRepository.findUserByEmail(userRegisterDTO.getEmail()) == null? true : false;
        if (!availableEmail) {
            registerStatus.setMessage(Constant.REGISTER_EXISTS_EMAIL);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }
        if (!Validator.validatePassword(userRegisterDTO.getPassword())) {
            registerStatus.setMessage(Constant.REGISTER_VALIDATE_FAILED_PASSWORD);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }
        if (!Validator.validateMathPassword(userRegisterDTO.getPassword(), userRegisterDTO.getConfirmPassword())) {
            registerStatus.setMessage(Constant.REGISTER_NOT_MATCH_PASSWORD);
            registerStatus.setRegisterStatus(false);
            return registerStatus;
        }
        registerStatus.setRegisterStatus(true);
        registerStatus.setMessage(Constant.REGISTER_SUCCESS);
        return registerStatus;
    }

}
