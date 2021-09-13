package com.example.urlapi.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class LoginDaoImp {
    public static List<Map<String,Object>> login(JdbcTemplate jdbcTemplate,String sql) {
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        if(list.size() != 0) {
            return list;
        }
        return null;
    }
}
