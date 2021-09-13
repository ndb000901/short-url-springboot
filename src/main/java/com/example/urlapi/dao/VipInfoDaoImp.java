package com.example.urlapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class VipInfoDaoImp {

    public static List<Map<String,Object>> getVipInfo(JdbcTemplate jdbcTemplate) {
        try {
            String sql = "select * from url_db.vip_info";
            List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
            return list;
        } catch (Exception ex) {
            return null;
        }

    }
}
