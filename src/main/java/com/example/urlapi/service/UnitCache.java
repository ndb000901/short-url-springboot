package com.example.urlapi.service;

//import com.alibaba.fastjson.JSONObject;
//import org.jboss.logging.Logger;
import com.example.urlapi.entity.Captcha;
import com.example.urlapi.entity.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UnitCache {

//    private Logger logger = Logger.getLogger(getClass());
    public static Map<String, SessionUser> codeMap = new HashMap<String, SessionUser>();
    public static Map<String, Captcha> registerCode = new HashMap<String, Captcha>();
//    public static Map<String, SessionUser> registerCode = new HashMap<String, SessionUser>();
//    public static Map<String, SessionUser> registerCode = new HashMap<String, SessionUser>();
//    @Autowired
//    private LoginService loginService;

    @PostConstruct
    public void init() {
//        logger.info("更新【token】缓存开始-----------------------");
//        long startTime = System.currentTimeMillis();

//        token = loginService.getToken();
//        codeMap.put("token",token);
//        logger.info("token：" + token);

//        long endTime = System.currentTimeMillis();
//        codeMap.put("e10adc3949ba59abbe56e057f20f883e","1");
        System.out.println("Session 已启动");
//        logger.info("更新【token】缓存结束，耗时： " + (endTime - startTime) + "ms");
    }

    @PreDestroy
    public void destroy() {
        //系统运行结束
    }

    /**
     * 这里是每2小时执行一次，更新token缓存
     * 可以根据token有效时长进行更新
     * @return
     */
    @Scheduled(cron = "0 0 0/2 * * ?")
    public void start() {
        init();
    }

}
