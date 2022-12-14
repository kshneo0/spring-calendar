package com.calendar.api.controller;

import com.calendar.api.dto.LoginReq;
import com.calendar.api.dto.SignUpReq;
import com.calendar.api.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * fileName : LoginApiController
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@RestController
@RequiredArgsConstructor
public class LoginApiController {
    private final LoginService loginService;

    @PostMapping("/api/sign-up")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpReq signUpReq, HttpSession session) {
        loginService.signUp(signUpReq, session);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginReq loginReq, HttpSession session) {
        loginService.login(loginReq, session);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        loginService.logout(session);
        return ResponseEntity.ok().build();
    }
}
