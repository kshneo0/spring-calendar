package com.calendar.core.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * fileName : User
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@NoArgsConstructor
@Getter
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private LocalDateTime createdAt = LocalDateTime.now();

    public User(String name, String email, String password, LocalDateTime birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }
}
