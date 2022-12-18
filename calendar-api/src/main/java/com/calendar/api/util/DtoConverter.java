package com.calendar.api.util;

import com.calendar.api.dto.EventDto;
import com.calendar.api.dto.NotificationDto;
import com.calendar.api.dto.ScheduleDto;
import com.calendar.api.dto.TaskDto;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.exception.CalendarException;
import com.calendar.core.exception.ErrorCode;

/**
 * fileName : DtoConverter
 * author :  KimSangHoon
 * date : 2022/12/18
 */
public abstract class DtoConverter {

    public static ScheduleDto fromSchedule(Schedule schedule) {
        switch (schedule.getScheduleType()) {
            case EVENT:
                return EventDto.builder()
                        .scheduleId(schedule.getId())
                        .description(schedule.getDescription())
                        .startAt(schedule.getStartAt())
                        .endAt(schedule.getEndAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();
            case TASK:
                return TaskDto.builder()
                        .scheduleId(schedule.getId())
                        .taskAt(schedule.getStartAt())
                        .description(schedule.getDescription())
                        .writerId(schedule.getWriter().getId())
                        .title(schedule.getTitle())
                        .build();
            case NOTIFICATION:
                return NotificationDto.builder()
                        .scheduleId(schedule.getId())
                        .notifyAt(schedule.getStartAt())
                        .writerId(schedule.getWriter().getId())
                        .title(schedule.getTitle())
                        .build();
            default:
                throw new CalendarException(ErrorCode.BAD_REQUEST);
        }
    }
}
