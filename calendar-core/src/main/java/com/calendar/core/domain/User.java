package com.calendar.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * fileName : User
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@NoArgsConstructor
@Getter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private LocalDateTime createdAt;

    public User(Long id, String name, String email, String password, LocalDateTime birthday, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }
}
