package com.example.urlapi.service;

import com.example.urlapi.dao.OldIndexListDaoImp;
import org.springframework.jdbc.core.JdbcTemplate;

public class OldIndexListService {
    public static void pushOldIndex(JdbcTemplate jdbcTemplate,String surl) {
        String sql = String.format("insert into old_index_list(old_index_list.index) values ('%s')",surl);
        OldIndexListDaoImp.recycleOldIndex(jdbcTemplate,sql);
    }
    public static String popOldIndex(JdbcTemplate jdbcTemplate) {
        String result = OldIndexListDaoImp.popOldIndex(jdbcTemplate);
        if (result != null) {
            return result;
        }
        return null;
    }
}
