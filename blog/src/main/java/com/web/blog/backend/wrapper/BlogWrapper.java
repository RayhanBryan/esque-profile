package com.web.blog.backend.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogWrapper {
    private Long blogId;
    private String url;
    private String title;
    private String textBlog;
}
