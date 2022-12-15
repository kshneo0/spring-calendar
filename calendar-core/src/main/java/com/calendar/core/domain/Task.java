package com.calendar.core.domain;

import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * fileName : Task
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@Getter
@NoArgsConstructor
public class Task {

    private Schedule schedule;

    public Task(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getTitle(){
        return schedule.getTitle();
    }
}
