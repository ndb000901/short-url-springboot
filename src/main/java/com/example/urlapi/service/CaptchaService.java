package com.example.urlapi.service;

import com.example.urlapi.entity.Captcha;
import org.joda.time.DateTime;

public class CaptchaService {
    public static void putRegisterCaptcha(String email, Captcha captcha) {
        UnitCache.registerCode.put(email, captcha);
    }

    public static boolean checkRegisterCaptcha(String email,String code) {
        Captcha captcha = UnitCache.registerCode.get(email);
        if (captcha != null && captcha.getValidTime().isAfterNow() && captcha.getCode().equals(code)) {
            UnitCache.registerCode.remove(email);
            return true;
        }
        return false;
    }



}
