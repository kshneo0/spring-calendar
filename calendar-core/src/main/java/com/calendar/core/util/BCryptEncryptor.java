package com.calendar.core.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * fileName : BCryptEncryptor
 * author :  KimSangHoon
 * date : 2022/12/17
 */
@Component
public class BCryptEncryptor implements Encryptor{
    @Override
    public String encrypt(String origin) {
        return BCrypt.hashpw(origin, BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String origin, String hashed) {
        try{
            return BCrypt.checkpw(origin, hashed);
        } catch(Exception e){
            return false;
        }
    }
}
