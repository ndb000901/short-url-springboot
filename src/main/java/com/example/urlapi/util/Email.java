package com.example.urlapi.util;

import com.example.urlapi.entity.Captcha;
import com.example.urlapi.service.CaptchaService;
import com.example.urlapi.service.UnitCache;
import org.apache.commons.codec.digest.DigestUtils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email extends Thread{
    private MessageType messageType;
    private String toEmail;
    public Email(MessageType messageType,String toEmail) {
        this.messageType = messageType;
        this.toEmail = toEmail;
    }

    @Override
    public void run() {
        try {
            sendCaptcha(this.messageType,this.toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void sendCaptcha(MessageType messageType,String toEmail) throws MessagingException {
        // 服务器地址:
        String smtp = "smtp.qq.com";
// 登录用户名:
        String username = "email@qq.com";
// 登录口令:
        String password = "your passwd";
// 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
// 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
// 设置debug模式便于调试:
//        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
// 设置发送方地址:
        message.setFrom(new InternetAddress("2138203503@qq.com"));
// 设置接收方地址:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
// 设置邮件主题:
        message.setSubject("皮卡短链平台", "UTF-8");
// 设置邮件正文:
        String emailMessage = createMessage(messageType);
        if (emailMessage == null) {
            return ;
        }
        message.setText(String.format(emailMessage, "UTF-8"));
// 发送:
        Transport.send(message);

    }

    public String createCaptcha() {
        return DigestUtils.md5Hex(String.valueOf(Math.random()));
    }

    public String createMessage(MessageType messageType) {
        switch (messageType) {
            case REGISTER:
                String code1 = createCaptcha().substring(0,6);
                putRegisterCode(code1);
                return String.format("我是皮卡短链平台管理员皮卡丘：\n您正在注册帐号，验证码%s，10分钟内有效",code1);
            case RESET_PASSWD:
                String code2 = createCaptcha().substring(0,6);
                return String.format("我是皮卡短链平台管理员皮卡丘：\n您正在重置帐号密码，验证码%s，10分钟内有效",code2);
            case UPDATE_PASSWD:
                String code3 = createCaptcha().substring(0,6);
                return String.format("我是皮卡短链平台管理员皮卡丘：\n您正在修改帐号密码，验证码%s，10分钟内有效",code3);
            default:
                return null;
        }

    }

    public void putRegisterCode(String code) {
        Captcha captcha = new Captcha(code);
        CaptchaService.putRegisterCaptcha(this.toEmail,captcha);
    }
}
