package com.web.blog.backend.wrapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AchievementWrapper {
    private Long achievementId;
    private String url;
    private String title;
    private String textAchievement;
}
