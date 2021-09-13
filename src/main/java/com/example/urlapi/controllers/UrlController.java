package com.example.urlapi.controllers;

import com.example.urlapi.entity.UrlAddBody;
import com.example.urlapi.entity.UrlDeleteBody;
import com.example.urlapi.entity.UrlUpdateBody;
import com.example.urlapi.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UrlController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/url/add")
    @ResponseBody
    public String addUrls(@RequestBody UrlAddBody urlAddBody) {
        UrlService.addUrls(jdbcTemplate,urlAddBody);

        return "dhchh";
    }


    @PostMapping("/url/update")
    @ResponseBody
    public String updateUrls(@RequestBody UrlUpdateBody urlUpdateBody) {
        UrlService.updateUrls(jdbcTemplate,urlUpdateBody);
        return "haha";
    }


    @PostMapping("/url/delete")
    @ResponseBody
    public String deleteUrls(@RequestBody UrlDeleteBody urlDeleteBody) {
        UrlService.deleteUrls(jdbcTemplate,urlDeleteBody);
        return "OK";
    }


    @GetMapping("/url/get")
    @ResponseBody
    public List<Map<String,Object>> getUrls(@RequestParam(required = true) String token) {

        return UrlService.getUrls(jdbcTemplate,token);
    }


}
