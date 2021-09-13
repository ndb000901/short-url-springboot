package com.example.urlapi.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Session {
    public HashMap<String , Object> sessions;

    public Session() {
        sessions = new HashMap<String , Object>();
        String user_id = "1";
        String token = "e10adc3949ba59abbe56e057f20f883e";
        sessions.put(token, user_id);
    }
}
