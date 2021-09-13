package com.example.urlapi.service;

import com.example.urlapi.entity.SessionUser;
import com.example.urlapi.util.SessionUtil;

public class SessionService {
    public static String pushSession(SessionUser sessionUser) {
        while(true) {
            String token = SessionUtil.createSession();
            if (UnitCache.codeMap.get(token) == null) {
                UnitCache.codeMap.put(token,sessionUser);
                return token;
            }
        }

    }

    public static SessionUser getSessionUser(String token) {
        SessionUser sessionUser = UnitCache.codeMap.get(token);
        if(sessionUser != null && sessionUser.getValidTime().isAfterNow()) {
            return sessionUser;
        }
        return null;
    }

    public static boolean checkSession(String token) {
        SessionUser sessionUser = UnitCache.codeMap.get(token);
        if(sessionUser != null && sessionUser.getValidTime().isAfterNow()) {
            return true;
        }
        return false;
    }
}
