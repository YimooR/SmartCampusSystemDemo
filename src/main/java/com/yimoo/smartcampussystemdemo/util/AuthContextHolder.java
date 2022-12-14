package com.yimoo.smartcampussystemdemo.util;

import javax.servlet.http.HttpServletRequest;
/**
 * @ClassName: AuthContextHolder
 * @Author: yimoorua
 * @Date: 2022/10/8 16:24
 * @Description:
 * @Version: 1.0
 **/

public class AuthContextHolder {
    //从请求头token获取userid
    public static Long getUserIdToken(HttpServletRequest request) {
        //从请求头token
        String token = request.getHeader("token");
        //调用工具类
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }

    //从请求头token获取name
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        String token = request.getHeader("token");
        //jwt从token获取username
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
