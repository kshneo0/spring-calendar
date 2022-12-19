package com.calendar.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName : TestController
 * author :  KimSangHoon
 * date : 2022/12/19
 */
@Controller
@RequiredArgsConstructor
public class TestController {
    private final JavaMailSender emailSender;

    @GetMapping("/api/mail")
    public @ResponseBody void sendTestMail() {
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("kshneo@gmail.com");
            helper.setSubject("제목입니다!!");
            helper.setText("여기는 테스트 내용입니다.^^");
        };
        emailSender.send(preparator);
    }

    @GetMapping("test/template")
    public String testTemplate(Model model){
        final Map<String, Object> props = new HashMap<>();
        props.put("title","타이틀입니다~");
        props.put("calendar","kshneo@gmail.com");
        props.put("period","언제부터 언제까지");
        props.put("attendees", List.of("test1@mail.io", "test2@mail.io","test3@mail.io"));
        props.put("acceptUrl","http://localhost:8080");
        props.put("rejectUrl","http://localhost:8080");
        model.addAllAttributes(props);
        return "engagement-email";
    }

}
