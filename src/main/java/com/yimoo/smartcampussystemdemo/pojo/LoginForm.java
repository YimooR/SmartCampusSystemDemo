package com.yimoo.smartcampussystemdemo.pojo;

import lombok.Data;

/**
 * @ClassName: LoginFormMapper
 * @Author: yimoorua
 * @Date: 2022/10/8 16:47
 * @Description: 用来接收前台登陆页面发来的信息
 * @Version: 1.0
 **/
@Data
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;
}
