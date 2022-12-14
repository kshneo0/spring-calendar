package com.calendar.core;

import com.calendar.core.domain.Engagement;
import com.calendar.core.domain.Event;
import com.calendar.core.domain.RequestStatus;
import com.calendar.core.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * fileName : DomainCreateTest
 * author :  KimSangHoon
 * date : 2022/12/15
 */
public class DomainCreateTest {
    @Test
    @DisplayName("이벤트 생성")
    void createEvent() {
        final User user1 = new User(1L,
                "user1",
                "email@email",
                "password",
                LocalDateTime.now(),
                LocalDateTime.now());
        final User user2 = new User(2L,
                "user2",
                "email@email",
                "password",
                LocalDateTime.now(),
                LocalDateTime.now());
        final Event event = new Event(1L,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "급만남",
                "내용무",
                user1,
                LocalDateTime.now());
        event.addEngagement(new Engagement(1L, event, user2, RequestStatus.REQUESTED, LocalDateTime.now()));
//        event.addEngagement(engagement);

        assertEquals("user1", event.getEngagements().get(0).getEvent().getWriter().getName());
    }
}
