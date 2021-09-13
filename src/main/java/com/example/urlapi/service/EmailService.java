package com.example.urlapi.service;

import com.example.urlapi.entity.RegisterResponseBody;
import com.example.urlapi.entity.StatusCode;
import com.example.urlapi.util.Email;
import com.example.urlapi.util.MessageType;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.mail.MessagingException;

public class EmailService {
    public static RegisterResponseBody sendMessage(JdbcTemplate jdbcTemplate, String email, MessageType messageType) throws MessagingException {

        if(UserService.isExistEmail(jdbcTemplate,email)) {
            return new RegisterResponseBody(StatusCode.REGISTER_ERROR1);
        }


        Thread thread = new Email(messageType,email);
        thread.start();
        System.out.println("haha");
        return new RegisterResponseBody(StatusCode.REGISTER_OK);

    }


}
