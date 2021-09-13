package com.example.urlapi.controllers;

import com.example.urlapi.entity.RegisterBody;
import com.example.urlapi.entity.RegisterResponseBody;
import com.example.urlapi.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/user/register")
    @ResponseBody
    public RegisterResponseBody register(@RequestBody RegisterBody registerBody) {
        System.out.println("sss");
        return RegisterService.register(jdbcTemplate,registerBody);
    }
}
