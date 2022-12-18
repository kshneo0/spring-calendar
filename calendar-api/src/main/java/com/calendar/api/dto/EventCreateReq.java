package com.calendar.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * fileName : CreateTaskReq
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Data
public class EventCreateReq {
    private final String title;
    private final String description;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final List<Long> attendeeIds;
}
