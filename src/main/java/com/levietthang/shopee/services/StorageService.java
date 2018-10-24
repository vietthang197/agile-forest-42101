package com.levietthang.shopee.services;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface StorageService {
    void storeFile(MultipartFile file);
    Resource  loadFile(String filename);
    void deleteFile();
    void deleteALlFile();
    void init();
}
