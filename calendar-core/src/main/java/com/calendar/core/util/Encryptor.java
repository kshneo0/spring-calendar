package com.calendar.core.util;

/**
 * fileName : Encryptor
 * author :  KimSangHoon
 * date : 2022/12/17
 */
public interface Encryptor {

    public String encrypt(String origin);
    boolean isMatch(String origin, String hashed);
}
