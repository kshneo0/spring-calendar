package com.calendar.core.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * fileName : UserCreateReq
 * author :  KimSangHoon
 * date : 2022/12/16
 */
@Data
public class UserCreateReq {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDateTime birthday;
}
