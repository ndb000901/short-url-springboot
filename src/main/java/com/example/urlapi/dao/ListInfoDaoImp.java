package com.example.urlapi.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ListInfoDaoImp {
    public static void addCurrentIndex(JdbcTemplate jdbcTemplate) {
        String sql = "update url_db.list_info set current_index=current_index+1";
        jdbcTemplate.update(sql);
    }

    public static int getCurrentIndex(JdbcTemplate jdbcTemplate) {
        String sql = "select * from url_db.list_info";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return Integer.valueOf(list.get(0).get("current_index").toString());
    }
}
