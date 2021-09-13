package com.example.urlapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImp {

    public static List<Map<String, Object>> getUserInfo(JdbcTemplate jdbcTemplate,String user_id) {
        String sql = String.format("select a.user_name, a.email, a.created_datetime, a.vip_datetime, a.current_url_num,b.vip_name,b.max from user as a  INNER JOIN  vip_info as b where a.vip_level = b.vip_level and a.user_id = %s",user_id);
//        String sql = "select * from user  INNER JOIN  vip_info where vip_info.vip_level = user.vip_level";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public static void addCurrentUrlNum(JdbcTemplate jdbcTemplate,String ower_id) {
        String sql = String.format("update url_db.user set current_url_num=current_url_num+1 where user_id=%s",ower_id);
        jdbcTemplate.update(sql);
    }

    public static void minusCurrentUrl(JdbcTemplate jdbcTemplate,String ower_id) {
        String sql = String.format("update url_db.user set current_url_num=current_url_num-1 where user_id=%s",ower_id);
        jdbcTemplate.update(sql);
    }

    public static void updateUserName(JdbcTemplate jdbcTemplate,String sql) {
        jdbcTemplate.update(sql);
    }

    public static void updateUserPasswd(JdbcTemplate jdbcTemplate,String sql) {
        jdbcTemplate.update(sql);
    }

    public static Integer checkPasswd(JdbcTemplate jdbcTemplate,String sql)  {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if(list.size() != 0) {
            return (Integer) list.get(0).get("result");
        }
        return null;
    }

    public static void updateUserEmail(JdbcTemplate jdbcTemplate,String sql) {
        jdbcTemplate.update(sql);
    }

    public static boolean isExistEmail(JdbcTemplate jdbcTemplate, String sql) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if (list.size() != 0) {
            return true;
        }
        return false;
    }

    public static boolean addUser(JdbcTemplate jdbcTemplate,String sql) {
        jdbcTemplate.update(sql);
        return true;
    }
}
