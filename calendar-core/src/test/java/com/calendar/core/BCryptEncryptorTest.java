package com.calendar.core;

import com.calendar.core.util.BCryptEncryptor;
import com.calendar.core.util.Encryptor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * fileName : BryptEncryptorTest
 * author :  KimSangHoon
 * date : 2022/12/17
 */
public class BCryptEncryptorTest {

    @Test
    void test() {
        final String origin = "password";
        final Encryptor encryptor = new BCryptEncryptor();
        final String hash = encryptor.encrypt(origin);

        assertTrue(encryptor.isMatch(origin, hash));

        final String origin2 = "passwordd";
        assertFalse(encryptor.isMatch(origin2, hash));


    }
}
