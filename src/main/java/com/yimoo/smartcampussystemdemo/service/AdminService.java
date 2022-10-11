package com.yimoo.smartcampussystemdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yimoo.smartcampussystemdemo.pojo.Admin;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AdminService
 * @Author: yimoorua
 * @Date: 2022/10/8 17:04
 * @Description:
 * @Version: 1.0
 **/

public interface AdminService extends IService<Admin> {
    Admin login(LoginForm loginForm);

    IPage<Admin> getAllAdmin(Page<Admin> page, String adminName);
}
