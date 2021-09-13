package com.example.urlapi.controllers;

import com.example.urlapi.service.UserService;
import com.example.urlapi.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/hello")
    public List<Map<String, Object>> hello() {
        return VipService.getVipInfos(jdbcTemplate);
    }


}
