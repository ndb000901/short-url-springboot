package com.example.urlapi.controllers;

import com.example.urlapi.entity.LoginBody;
import com.example.urlapi.entity.LoginResponseBody;
import com.example.urlapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @PostMapping("/user/login")
    @ResponseBody
    public LoginResponseBody login(@RequestBody(required = true) LoginBody loginBody) {
        String token = LoginService.login(jdbcTemplate, loginBody);
        LoginResponseBody responseBody = new LoginResponseBody(token);
        System.out.println(token);
        return  responseBody;
    }
}
