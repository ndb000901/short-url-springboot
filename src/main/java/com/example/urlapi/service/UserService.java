package com.example.urlapi.service;

import com.example.urlapi.dao.UserDaoImp;
import com.example.urlapi.entity.RegisterBody;
import com.example.urlapi.entity.SessionUser;
import com.example.urlapi.entity.UserNameUpdateBody;
import com.example.urlapi.entity.UserUpdatePasswdBody;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserService {

    public static List<Map<String,Object>> getUserInfo(JdbcTemplate jdbcTemplate,String token) {
        SessionUser sessionUser = SessionService.getSessionUser(token);
        if(sessionUser != null) {
            return UserDaoImp.getUserInfo(jdbcTemplate,sessionUser.getUser_id());
        }
        return null;
    }

    public static void updatePasswd(JdbcTemplate jdbcTemplate, UserUpdatePasswdBody userUpdatePasswdBody) {
        SessionUser sessionUser = SessionService.getSessionUser(userUpdatePasswdBody.getToken());
//        if(sessionUser != null) {
//            String ower_id = sessionUser.getUser_id();
//            if(UserService.checkPasswd(jdbcTemplate,userUpdatePasswdBody.getOldPasswd(),ower_id).intValue() == 1) {
//                String sql = String.format("update user set passwd=md5('%s') where user_id=%s",userUpdatePasswdBody.getNewPasswd(),ower_id);
//                UserDaoImp.updateUserPasswd(jdbcTemplate,sql);
//            }
//        }
        if(sessionUser != null) {
            String oldPasswd = userUpdatePasswdBody.getOldPasswd();
            String newPasswd = userUpdatePasswdBody.getNewPasswd();
            String user_id = sessionUser.getUser_id();
            String sql = String.format("update user set passwd=md5('%s') where user_id='%s' and passwd=md5('%s')",newPasswd,user_id,oldPasswd);
            UserDaoImp.updateUserPasswd(jdbcTemplate,sql);
        }

    }

    public static void resetPasswd() {

    }

    public static void updateUserName(JdbcTemplate jdbcTemplate, UserNameUpdateBody userNameUpdateBody) {
        SessionUser sessionUser = SessionService.getSessionUser(userNameUpdateBody.getToken());
        if (sessionUser != null) {
            String ower_id = sessionUser.getUser_id();
            String sql = String.format("update url_db.user set user_name='%s' where user_id=%s",userNameUpdateBody.getUserName(),ower_id);
            UserDaoImp.updateUserName(jdbcTemplate,sql);
        }

    }

    public static void updateEmail() {

    }

    public static void updataAvatar() {

    }

    public static Integer checkPasswd(JdbcTemplate jdbcTemplate,String passwd,String ower_id) {
        String sql = String.format("select md5('%s') = (select passwd from user where user_id=%s) as result",passwd,ower_id);
        return UserDaoImp.checkPasswd(jdbcTemplate,sql);
    }

    public static boolean isExistEmail(JdbcTemplate jdbcTemplate,String email) {
        String sql = String.format("select email from user where email='%s'",email);
        return UserDaoImp.isExistEmail(jdbcTemplate,sql);
    }

    public static boolean addUser(JdbcTemplate jdbcTemplate, RegisterBody registerBody) {
        String sql = String.format("insert into user(user_name, email, passwd) VALUES ('%s','%s',md5('%s'))",registerBody.getUser_name(),registerBody.getEmail(),registerBody.getPasswd());
        return UserDaoImp.addUser(jdbcTemplate,sql);
    }
}
