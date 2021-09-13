package com.example.urlapi.service;

import com.example.urlapi.dao.UrlDaoImp;
import com.example.urlapi.dao.UserDaoImp;
import com.example.urlapi.entity.*;
import com.example.urlapi.util.UrlConvert;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UrlService {

    public static List<Map<String,Object>> getUrls(JdbcTemplate jdbcTemplate,String token) {
        SessionUser sessionUser = SessionService.getSessionUser(token);
        if(sessionUser != null) {
            return UrlDaoImp.getUrls(jdbcTemplate,sessionUser.getUser_id());
        }
        return null;
    }

    public static List<Map<String,Object>> getLongUrlByShortUrl(JdbcTemplate jdbcTemplate,String surl) {
        List<Map<String,Object>> list = UrlDaoImp.getLongUrlByShortUrl(jdbcTemplate,surl);
        return list;
    }

    public static void addUrls(JdbcTemplate jdbcTemplate, UrlAddBody urlAddBody) {

        SessionUser sessionUser = SessionService.getSessionUser(urlAddBody.getToken());
        if (sessionUser != null) {
            String ower_id = sessionUser.getUser_id();
            for(UrlAdd url: urlAddBody.getList()) {
                String sql = String.format("insert into url_db.urls(surl, lurl, ower_id) VALUES ('%s','%s',%s)", UrlConvert.encode10To62(ListInfoService.getCurrentIndex(jdbcTemplate) + 1),url.getLurl(),ower_id);
                UrlDaoImp.addUrl(jdbcTemplate,sql,ower_id);
            }
        }


    }

    public static void updateUrls(JdbcTemplate jdbcTemplate, UrlUpdateBody urlUpdateBody) {
        SessionUser sessionUser = SessionService.getSessionUser(urlUpdateBody.getToken());
        if (sessionUser != null) {
            String sql = String.format("update url_db.urls set lurl='%s',alias='%s' where surl='%s' and ower_id='%s'",urlUpdateBody.getLurl(),urlUpdateBody.getAlias(),urlUpdateBody.getSurl(),sessionUser.getUser_id());
            UrlDaoImp.updateUrl(jdbcTemplate,sql);
        }


    }

    public static void deleteUrls(JdbcTemplate jdbcTemplate, UrlDeleteBody urlDeleteBody) {
        SessionUser sessionUser = SessionService.getSessionUser(urlDeleteBody.getToken());
        if( sessionUser != null) {
            String ower_id = sessionUser.getUser_id();
//            if(ower_id.equals(getOwerIdBySurl(jdbcTemplate,urlDeleteBody.getSurl()))) {
//                return;
//            }
            String sql = String.format("delete from url_db.urls where surl='%s' and ower_id='%s'",urlDeleteBody.getSurl(),ower_id);
            UrlDaoImp.deleteUrl(jdbcTemplate,sql,ower_id,urlDeleteBody.getSurl());
        }


    }

    public static String getOwerIdBySurl(JdbcTemplate jdbcTemplate, String surl) {
        String sql = String.format("select ower_id from urls where surl='%s'", surl);
        String ower_id = UrlService.getOwerIdBySurl(jdbcTemplate,sql);
        return ower_id;
    }


}
