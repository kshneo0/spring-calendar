package com.calendar.api.service;

import com.calendar.api.controller.BatchController;
import com.calendar.api.dto.EngagementEmailStuff;
import com.calendar.core.domain.entity.Engagement;

/**
 * fileName : Emailervice
 * author :  KimSangHoon
 * date : 2022/12/18
 */
public interface EmailService {
    void sendEngagement(EngagementEmailStuff engagement);

    void sendAlarmMail(BatchController.SendMailBatchReq req);
}
