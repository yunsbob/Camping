package com.ssafy.camping.member.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang3.RandomStringUtils;
@Component
public class PasswordUtil {

    public String encodePassword(String rawPassword) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(rawPassword.getBytes());

        StringBuilder builder = new StringBuilder();
        for (byte b : md.digest()) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public boolean match(String rawPassword, String targetPassword) throws NoSuchAlgorithmException {
        return encodePassword(rawPassword).equals(targetPassword);
    }

    public String getRandomPassword(int length){
        return RandomStringUtils.random(12, 33, 125, true, true);
    }

}