package com.levietthang.shopee.repositories.custom;

public interface CustomUserDetailsRepository {
    boolean checkExistsEmail(String email);
}
