package com.example.urlapi.controllers;

import com.example.urlapi.entity.RegisterResponseBody;
import com.example.urlapi.service.EmailService;
import com.example.urlapi.util.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class CaptchaController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/captcha/passwd/reset")
    @ResponseBody
    public String sendResetPasswdCaptcha(@RequestParam String token) throws MessagingException {
//        EmailService.sendMessage(token,MessageType.RESET_PASSWD);
        return "reset";
    }

    @GetMapping("/captcha/email/update")
    @ResponseBody
    public String sendUpdateEmailCaptcha(@RequestParam String token) throws MessagingException {
//        EmailService.sendMessage(token,MessageType.UPDATE_PASSWD);
        return "update";
    }

    @GetMapping("/captcha/user/register")
    @ResponseBody
    public RegisterResponseBody sendRegisterUserCaptcha(@RequestParam String email) throws MessagingException {
        if(email == null) {
            return null;
        }
        return EmailService.sendMessage(jdbcTemplate,email,MessageType.REGISTER);
    }
}
