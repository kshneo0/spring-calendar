package com.calendar.core.domain.entity;

import com.calendar.core.util.Encryptor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * fileName : User
 * author :  KimSangHoon
 * date : 2022/12/15
 */
@NoArgsConstructor
@Getter
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    private String name;
    private String email;
    private String password;
    private LocalDate birthday;

    public User(String name, String email, String password, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public boolean isMatch(Encryptor encryptor, String password) {
        return encryptor.isMatch(password, this.password);
    }
}
