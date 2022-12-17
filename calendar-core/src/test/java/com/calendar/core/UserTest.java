package com.calendar.core;

import com.calendar.core.domain.entity.User;
import com.calendar.core.util.Encryptor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * fileName : UserTest
 * author :  KimSangHoon
 * date : 2022/12/17
 */
class UserTest {

    private final Encryptor alwaysMatchEncryptor = new Encryptor(){
        @Override
        public String encrypt(String origin) {
            return origin;
        }

        @Override
        public boolean isMatch(String origin, String hashed) {
            return true;
        }
    };

    @Test
    void isMatchTest() {
        final User me = new User("name","email","pw", LocalDate.now());
        assertEquals(true, me.isMatch(alwaysMatchEncryptor,"aaaaa"));
    }
}