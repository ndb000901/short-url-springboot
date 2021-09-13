package com.example.urlapi.service;

import com.example.urlapi.dao.LoginDaoImp;
import com.example.urlapi.entity.LoginBody;
import com.example.urlapi.entity.SessionUser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class LoginService {

    public static String login(JdbcTemplate jdbcTemplate, LoginBody loginBody) {
        if(loginBody.getEmail() == null || loginBody.getPasswd() == null
            || loginBody.getPasswd().equals("") || loginBody.getEmail().equals("")) {
            return null;
        }
        String sql = String.format("select user_id,email,passwd from user where passwd=md5('%s') and email='%s'",loginBody.getPasswd(),loginBody.getEmail());
        List<Map<String,Object>> list = LoginDaoImp.login(jdbcTemplate,sql);
        if (list != null) {
            SessionUser sessionUser = new SessionUser(list.get(0).get("email").toString(),list.get(0).get("user_id").toString(),list.get(0).get("passwd").toString());
            return SessionService.pushSession(sessionUser);
        }
        return null;
    }
}
