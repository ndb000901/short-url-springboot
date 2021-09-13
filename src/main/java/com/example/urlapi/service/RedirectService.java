package com.example.urlapi.service;

import com.example.urlapi.dao.UrlDaoImp;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class RedirectService {

    public static String getLongUrl(JdbcTemplate jdbcTemplate,String surl) {
        if (isLetterDigit(surl) && surl.length() > 0 && surl.length() <= 6) {
            List<Map<String, Object>> list = UrlDaoImp.getLongUrlByShortUrl(jdbcTemplate,surl);
            if(list.size() != 0) {
                RedirectService.addClickCount(jdbcTemplate,surl);
                return "redirect:" + list.get(0).get("lurl");
            }
        }
        return "redirect:http://127.0.0.1:8080";
    }

    public static boolean isLetterDigit(String str) {
        String regex = "^[a-z0-9A-Z]+$";
        return str.matches(regex);
    }

    public static void addClickCount(JdbcTemplate jdbcTemplate,String surl) {
        UrlDaoImp.addClickCount(jdbcTemplate,surl);
    }

}
