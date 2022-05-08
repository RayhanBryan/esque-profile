package com.web.blog.backend.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityWrapper {
    private Long activityId;
    private String url;
    private String title;
    private String textActivity;
}
