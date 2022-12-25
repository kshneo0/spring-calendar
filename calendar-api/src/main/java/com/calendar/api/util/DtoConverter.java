package com.calendar.api.util;

import com.calendar.api.dto.ForListEventDto;
import com.calendar.api.dto.ForListNotificationDto;
import com.calendar.api.dto.ForListScheduleDto;
import com.calendar.api.dto.ForListTaskDto;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.exception.CalendarException;
import com.calendar.core.exception.ErrorCode;

/**
 * fileName : DtoConverter
 * author :  KimSangHoon
 * date : 2022/12/18
 */
public abstract class DtoConverter {

    public static ForListScheduleDto toForListDto(Schedule schedule) {
        switch (schedule.getScheduleType()) {
            case EVENT:
                return ForListEventDto.builder()
                        .scheduleId(schedule.getId())
                        .description(schedule.getDescription())
                        .startAt(schedule.getStartAt())
                        .endAt(schedule.getEndAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();
            case TASK:
                return ForListTaskDto.builder()
                        .scheduleId(schedule.getId())
                        .taskAt(schedule.getStartAt())
                        .description(schedule.getDescription())
                        .writerId(schedule.getWriter().getId())
                        .title(schedule.getTitle())
                        .build();
            case NOTIFICATION:
                return ForListNotificationDto.builder()
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
