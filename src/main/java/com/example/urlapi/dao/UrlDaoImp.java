package com.example.urlapi.dao;

import com.example.urlapi.entity.Url;
import com.example.urlapi.service.OldIndexListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UrlDaoImp {

    public static List<Map<String, Object>> getUrls(JdbcTemplate jdbcTemplate,String ower_id) {
        String sql = String.format("select a.surl,a.lurl,a.click_count,a.created_datetime,a.alias from urls as a where ower_id=%s", ower_id);
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public static List<Map<String, Object>> getLongUrlByShortUrl(JdbcTemplate jdbcTemplate, String shortUrl) {

        String sql = String.format("select * from url_db.urls where surl='%s'", shortUrl);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;

    }

    public static void addClickCount(JdbcTemplate jdbcTemplate,String surl) {
        String sql = String.format("update url_db.urls set click_count=click_count+1 where surl='%s'", surl);
        jdbcTemplate.update(sql);
    }

    public static void addUrl(JdbcTemplate jdbcTemplate,String sql,String ower_id) {
        jdbcTemplate.update(sql);
        UserDaoImp.addCurrentUrlNum(jdbcTemplate,ower_id);
        ListInfoDaoImp.addCurrentIndex(jdbcTemplate);
    }

    public static void updateUrl(JdbcTemplate jdbcTemplate,String sql) {
        jdbcTemplate.update(sql);
    }

    public static void deleteUrl(JdbcTemplate jdbcTemplate,String sql,String ower_id,String surl) {
        jdbcTemplate.update(sql);
        UserDaoImp.minusCurrentUrl(jdbcTemplate,ower_id);
        OldIndexListService.pushOldIndex(jdbcTemplate,surl);
    }

    public static String getOwerIdBySurl(JdbcTemplate jdbcTemplate, String sql) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if (list.size() != 0) {
            return list.get(0).get("ower_id").toString();
        }
        return null;
    }



}
