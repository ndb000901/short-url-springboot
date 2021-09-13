package com.example.urlapi.controllers;

import com.example.urlapi.entity.StatusCode;
import com.example.urlapi.entity.TokenStatus;
import com.example.urlapi.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {
    @GetMapping("/session/test")
    @ResponseBody
    public static TokenStatus session(@RequestParam(required = true) String token) {
        if(token == null || token.equals("")) {
            return new TokenStatus(StatusCode.TOKEN_INVALID);
        }
        if (SessionService.checkSession(token)) {
            return new TokenStatus(StatusCode.TOKEN_VALID);
        }
        return new TokenStatus(StatusCode.TOKEN_INVALID);
    }
}
