package com.example.urlapi.service;

import com.example.urlapi.entity.RegisterBody;
import com.example.urlapi.entity.RegisterResponseBody;
import com.example.urlapi.entity.StatusCode;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterService {
    public static RegisterResponseBody register(JdbcTemplate jdbcTemplate, RegisterBody registerBody) {
        if (CaptchaService.checkRegisterCaptcha(registerBody.getEmail(),registerBody.getCaptcha())) {
            UserService.addUser(jdbcTemplate,registerBody);
            return new RegisterResponseBody(StatusCode.REGISTER_OK);
        }
        return new RegisterResponseBody(StatusCode.REGISTER_ERROR2);
    }
}
