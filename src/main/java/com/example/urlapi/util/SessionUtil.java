package com.example.urlapi.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SessionUtil {
    public static String createSession() {
        return DigestUtils.md5Hex(String.valueOf(Math.random()));
    }
}
