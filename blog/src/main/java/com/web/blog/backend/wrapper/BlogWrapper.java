package com.web.blog.backend.wrapper;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogWrapper {
    private Long blogId;
    private String url;
    private String title;
    private String textBlog;

    @Transient
    public String getPhotosImagePath() {
        if (url == null || blogId == null)
            return null;

        return "/blog-photos/" + blogId + "/" + url;
    }
}
