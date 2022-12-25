package com.calendar.api.controller;

import com.calendar.api.service.EmailService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * author :  sanghoonkim
 * date : 2022/12/25
 */
@RequiredArgsConstructor
@RestController
public class BatchController {
    private final EmailService emailService;

    @PostMapping("/api/batch/mail")
    public ResponseEntity<Void> sendMail(@RequestBody List<SendMailBatchReq> req) {
        req.forEach(r -> emailService.sendAlarmMail(r));
        return ResponseEntity.ok().build();
    }


    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class SendMailBatchReq {
        private Long id;    //scheduleId
        private LocalDateTime startAt;
        private String title;
        private String userMail;
    }
}
