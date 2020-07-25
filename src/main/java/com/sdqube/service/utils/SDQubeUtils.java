package com.sdqube.service.utils;

import com.google.common.hash.Hashing;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:32 AM
 */
public class SDQubeUtils {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String BYTE_CONV_ERR_MSG = "Could not convert data into bytes.";


    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String passwordHash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }

    public static String sha512(String data) {
        byte[] bytes = data.getBytes();
        if (null == bytes) throw new IllegalArgumentException(BYTE_CONV_ERR_MSG);
        return Hashing.sha512().hashBytes(bytes).toString();
    }

    public static String sha256(byte[] data) {
        return Hashing.sha256().hashBytes(data).toString();
    }

    public static String sha256(String data) {
        byte[] bytes = data.getBytes();
        if (null == bytes) throw new IllegalArgumentException(BYTE_CONV_ERR_MSG);
        return sha256(bytes);
    }

    public static String doubleSha256(String data) {
        byte[] bytes = data.getBytes();
        if (null == bytes) throw new IllegalArgumentException(BYTE_CONV_ERR_MSG);
        return sha256(sha256(bytes));
    }

    public static String hmacSha512(String secret, byte[] data) {
        byte[] key = secret.getBytes();
        if (null == key) throw new IllegalArgumentException(BYTE_CONV_ERR_MSG);
        return Hashing.hmacSha512(key).hashBytes(data).toString();
    }

    public static String encodeBase64(String text) {
        if (null == text) {
            return null;
        }
        return java.util.Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String encodeBase64(byte[] text) {
        if (null == text) {
            return null;
        }
        return java.util.Base64.getEncoder().encodeToString(text);
    }

    public static String decodeBase64(String base64) {
        return new String(java.util.Base64.getDecoder().decode(base64));
    }
}
