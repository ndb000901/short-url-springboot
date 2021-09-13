package com.example.urlapi.entity;

public class StatusCode {
    // 注册成功
    public static int REGISTER_OK = 1000;
    // 该邮箱已注册
    public static int REGISTER_ERROR1 = 1001;
    // 验证码错误
    public static int REGISTER_ERROR2 = 1002;


    // token状态码

    // Token有效
    public static int TOKEN_VALID = 2000;

    // Token无效
    public static int TOKEN_INVALID = 2001;
}
