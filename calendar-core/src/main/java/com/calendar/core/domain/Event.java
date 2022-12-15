package com.calendar.core.domain;

import com.calendar.core.domain.entity.Engagement;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * fileName : Event
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@Getter
@NoArgsConstructor
public class Event {
    private Schedule schedule;

    public Event(Schedule schedule) {
        this.schedule = schedule;
    }
}
