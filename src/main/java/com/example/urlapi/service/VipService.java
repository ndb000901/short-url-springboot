package com.example.urlapi.service;

import com.example.urlapi.dao.VipInfoDaoImp;
import com.example.urlapi.entity.VipInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class VipService {

    public static List<Map<String, Object>> getVipInfos(JdbcTemplate jdbcTemplate) {
        return VipInfoDaoImp.getVipInfo(jdbcTemplate);
    }

}
