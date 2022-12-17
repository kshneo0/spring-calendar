package com.calendar.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * fileName : CreateTaskReq
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Data
public class TaskCreateReq {
    private final String title;
    private final String description;
    private final LocalDateTime taskAt;
}
