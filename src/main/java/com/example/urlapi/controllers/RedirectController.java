package com.example.urlapi.controllers;

import com.example.urlapi.entity.Url;
import com.example.urlapi.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RedirectController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/s/*")
    public String redirect() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String surl = request.getRequestURI().substring(3);
        return RedirectService.getLongUrl(jdbcTemplate,surl);
    }

}
