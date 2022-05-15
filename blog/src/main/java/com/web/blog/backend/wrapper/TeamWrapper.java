package com.web.blog.backend.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamWrapper {
    private Long teamId;
    private String url;
    private String title;
    private String textTeam;
    private String position;
}
