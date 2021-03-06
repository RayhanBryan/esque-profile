package com.web.blog.backend.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper {
    private Long userId;
    private String userName;
    private String password;
}
