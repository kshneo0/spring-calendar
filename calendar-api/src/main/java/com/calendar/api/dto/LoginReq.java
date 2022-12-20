package com.calendar.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * fileName : LoginReq
 * author :  KimSangHoon
 * date : 2022/12/16
 */
@Data
public class LoginReq {
    @Email
    @NotBlank
    private final String email;

    @Size(min = 5, message = "5자리 이상 입력해 주세요.")
    @NotBlank
    private final String password;
}
