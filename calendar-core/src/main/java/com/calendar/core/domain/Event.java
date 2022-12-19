package com.calendar.core.domain;

import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.util.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    public boolean isOverlapped(LocalDateTime startAt, LocalDateTime endAt) {
        return schedule.getStartAt().isBefore(endAt) && startAt.isBefore(schedule.getEndAt());
    }

    public String getTitle(){
        return this.schedule.getTitle();
    }

    public Period getPeriod() {
        return Period.of(this.schedule.getStartAt(), this.schedule.getEndAt());
    }
}
