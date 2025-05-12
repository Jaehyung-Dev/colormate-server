package com.jh.colormateserver.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private String nickname;
    private String type;
    private String content;
}
