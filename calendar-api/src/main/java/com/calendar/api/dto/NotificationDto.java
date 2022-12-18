package com.calendar.api.dto;

import com.calendar.core.domain.ScheduleType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * fileName : EventDto
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Data
@Builder
public class NotificationDto implements ScheduleDto{

    private final Long scheduleId;
    private final LocalDateTime notifyAt;
    private final String title;
    private final Long writerId;

    @Override
    public ScheduleType getScheduleType() {
        return ScheduleType.NOTIFICATION;
    }
}
