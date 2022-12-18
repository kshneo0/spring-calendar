package com.calendar.api.service;

import com.calendar.core.domain.entity.Engagement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * fileName : FakeEmailService
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Profile("dev")
@Service
public class FakeEmailService implements EmailService {
    @Override
    public void sendEngagement(Engagement engagement) {
        System.out.println("send email. email:" + engagement.getAttendee().getEmail() + ", scheduleId: " + engagement.getSchedule().getId());
    }
}
