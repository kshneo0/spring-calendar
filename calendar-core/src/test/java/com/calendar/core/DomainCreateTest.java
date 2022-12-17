package com.calendar.core;

import com.calendar.core.domain.ScheduleType;
import com.calendar.core.domain.Task;
import com.calendar.core.domain.entity.Engagement;
import com.calendar.core.domain.Event;
import com.calendar.core.domain.RequestStatus;
import com.calendar.core.domain.entity.Schedule;
import com.calendar.core.domain.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * fileName : DomainCreateTest
 * author :  KimSangHoon
 * date : 2022/12/15
 */
public class DomainCreateTest {
    @Test
    void createEvent() {
        final User me = new User("user1", "email@email", "password", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), me);
        assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK);
        assertEquals(taskSchedule.toTask().getTitle(), "할일");
    }
}
