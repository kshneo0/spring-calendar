package com.calendar.api.dto;

import com.calendar.core.domain.ScheduleType;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * fileName : EventDto
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Data
@Builder
public class TaskDto implements ScheduleDto{

    private final Long scheduleId;
    private final LocalDateTime taskAt;
    private final String title;
    private final String description;
    private final Long writerId;

    @Override
    public ScheduleType getScheduleType() {
        return ScheduleType.TASK
                ;
    }
}
