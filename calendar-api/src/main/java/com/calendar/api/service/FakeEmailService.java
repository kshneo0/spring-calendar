package com.calendar.api.service;

import com.calendar.api.controller.BatchController;
import com.calendar.api.dto.EngagementEmailStuff;
import com.calendar.core.domain.entity.Engagement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * fileName : FakeEmailService
 * author :  KimSangHoon
 * date : 2022/12/18
 */
@Profile("test")
@Service
public class FakeEmailService implements EmailService {
    @Override
    public void sendEngagement(EngagementEmailStuff stuff) {
        System.out.println("send email. email:" + stuff.getSubject());
    }

    @Override
    public void sendAlarmMail(BatchController.SendMailBatchReq req) {
        System.out.println("send alarm. "+ req.toString());
    }
}
