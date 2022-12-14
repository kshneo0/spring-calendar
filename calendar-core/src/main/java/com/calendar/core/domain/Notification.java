package com.calendar.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * fileName : Notification
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@Getter
@NoArgsConstructor
public class Notification {

    private Long id;
    private LocalDateTime notifyAt;
    private String title;
    private String description;
    private User writer;
    private LocalDateTime createdAt;

}
