package com.calendar.api.dto;

import lombok.Getter;

/**
 * fileName : AuthUser
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Getter
public class AuthUser {
    private final Long id;

    private AuthUser(Long id) {
        this.id = id;
    }

    public static AuthUser of(Long id) {
        return new AuthUser(id);
    }
}
