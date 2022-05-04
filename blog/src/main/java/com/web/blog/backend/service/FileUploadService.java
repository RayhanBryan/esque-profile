package com.web.blog.backend.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    public void uploadFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
        multipartFile.transferTo(new File("D:\\Vue-Project\\esque-profile\\src\\assets\\"
                + multipartFile.getOriginalFilename()));
    }
}