package com.calendar.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * fileName : LoginReq
 * author :  KimSangHoon
 * date : 2022/12/16
 */
@Data
public class LoginReq {
    private final String email;
    private final String password;
}
