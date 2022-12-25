package com.calendar.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */


@Builder
@Data
public class SharedScheduleDto {
    private final Long userId;
    private final String name;
    private final Boolean me;
    private final List<ForListScheduleDto> schedules;
}