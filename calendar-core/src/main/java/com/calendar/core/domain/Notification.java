package com.calendar.core.domain;

import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * fileName : Notification
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@Getter
@NoArgsConstructor
public class Notification {

    private Schedule schedule;

    public Notification(Schedule schedule) {
        this.schedule = schedule;
    }
}
