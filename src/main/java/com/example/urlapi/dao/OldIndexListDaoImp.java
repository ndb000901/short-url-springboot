package com.example.urlapi.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class OldIndexListDaoImp {

    public static void recycleOldIndex(JdbcTemplate jdbcTemplate, String sql) {
        jdbcTemplate.update(sql);
    }

    public static String popOldIndex(JdbcTemplate jdbcTemplate) {
        String sql = "select * from old_index_list limit 1";
        List<Map<String, Object>> list = (jdbcTemplate.queryForList(sql));
        if (list.size() != 0) {
            return list.get(0).get("index").toString();
        }
        return null;
    }
}
