package com.example.urlapi.service;

import com.example.urlapi.dao.ListInfoDaoImp;
import org.springframework.jdbc.core.JdbcTemplate;

public class ListInfoService {
    public static int getCurrentIndex(JdbcTemplate jdbcTemplate) {
        return ListInfoDaoImp.getCurrentIndex(jdbcTemplate);
    }
}
