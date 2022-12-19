package com.calendar.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

/**
 * fileName : TestController
 * author :  KimSangHoon
 * date : 2022/12/19
 */
@RestController
@RequiredArgsConstructor
public class TestController {
    private final JavaMailSender emailSender;

    @GetMapping("/api/mail")
    public void sendTestMail() {
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("kshneo@gmail.com");
            helper.setSubject("제목입니다!!");
            helper.setText("여기는 테스트 내용입니다.^^");
        };
        emailSender.send(preparator);
    }

}
