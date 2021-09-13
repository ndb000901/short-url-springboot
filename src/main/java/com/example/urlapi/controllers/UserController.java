package com.example.urlapi.controllers;

import com.example.urlapi.entity.User;
import com.example.urlapi.entity.UserNameUpdateBody;
import com.example.urlapi.entity.UserUpdatePasswdBody;
import com.example.urlapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/user/info")
    @ResponseBody
    public List<Map<String, Object>> getUserInfo(@RequestParam String token) {
        return UserService.getUserInfo(jdbcTemplate,token);
    }

    @PostMapping("/user/name/update")
    @ResponseBody
    public String updateName(@RequestBody UserNameUpdateBody userNameUpdateBody) {
        UserService.updateUserName(jdbcTemplate,userNameUpdateBody);
        return "";
    }

    @PostMapping("/user/email/update")
    @ResponseBody
    public String updateEmail() {
        return "";
    }

    @PostMapping("/user/passwd/update")
    @ResponseBody
    public String updatePasswd(@RequestBody UserUpdatePasswdBody userUpdatePasswdBody) {
        UserService.updatePasswd(jdbcTemplate,userUpdatePasswdBody);
        return "";
    }

    @PostMapping("/user/passwd/reset")
    @ResponseBody
    public String resetPasswd() {
        return "";
    }

    @PostMapping("/user/avatar/update")
    @ResponseBody
    public String updateAvatar() {
        return "";
    }
}
