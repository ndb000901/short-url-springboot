package com.example.urlapi.controllers;

import com.example.urlapi.entity.VipInfo;
import com.example.urlapi.service.EmailService;
import com.example.urlapi.service.OldIndexListService;
import com.example.urlapi.service.UnitCache;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @RequestMapping("/test")
    public String test(@RequestParam(value = "name",required = false)String name,@RequestParam(value = "id",required = false) String id) {

        System.out.println(name);
        System.out.println(id);
        System.out.println("haha");
        return name + id;
    }



//    @ResponseBody
////    @GetMapping("/test/post")
//    @PostMapping("/test/post")
//    public String posttest(@RequestParam(value = "vip_level",required = false) Integer vip_level,
//                           @RequestParam(value = "name", required = false) String name,
//                           @RequestParam(value = "price_1",required = false) Integer price_1,
//                           @RequestParam(value = "price_3", required = false) Integer price_3,
//                           @RequestParam(value = "price_12", required = false) Integer price_12,
//                           @RequestParam(value = "max", required = false) Integer max) {
//        System.out.println(vip_level);
//        System.out.println(name);
//        System.out.println(price_1);
//        System.out.println(price_3);
//        System.out.println(price_12);
//        System.out.println(max);
//        System.out.println("world");
//        return "vip_level: " + vip_level + "\nname: " + name +
//                "\nprice_1: " + price_1 + "\nprice_3: " + price_3 +
//                "\nprice_12: " + price_12 + "\nmax: " + max;
//    }


    @ResponseBody
//    @GetMapping("/test/post")
    @PostMapping("/test/post")
    public String posttest(@RequestBody VipInfo info) {
        System.out.println(info.getVip_level());
        System.out.println(info.getName());
        System.out.println(info.getPrice_1());
        System.out.println(info.getPrice_3());
        System.out.println(info.getPrice_12());
        System.out.println(info.getMax());
        System.out.println("world");
        return "vip_level: " + info.getVip_level() + "\nname: " + info.getName() +
                "\nprice_1: " + info.getPrice_1() + "\nprice_3: " + info.getPrice_3() +
                "\nprice_12: " + info.getPrice_12() + "\nmax: " + info.getMax();
//    return info.toString();
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test1() throws MessagingException {
//        EmailService.sendMessage();

        System.out.println(UnitCache.codeMap.get("e10adc3949ba59abbe56e057f20f883e"));
        return "result";
    }

}
