package com.web.blog.backend.wrapper;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogWrapper implements Serializable {
    private Long blogId;
    private String url;
    private String title;
    private String textBlog;
    // private MultipartFile multipartFile;
}
