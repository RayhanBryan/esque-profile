package com.web.blog.backend.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class FileUploadService {

    public void uploadFile(MultipartFile file, Long blogId) throws IllegalStateException, IOException {
        File f = new File("./src/assets/blog/" + blogId + ".jpg");
        f.createNewFile();
        FileOutputStream output = new FileOutputStream(f);
        output.write(file.getBytes());
        output.close();
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
    }

}
