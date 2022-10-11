package com.yimoo.smartcampussystemdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimoo.smartcampussystemdemo.mapper.AdminMapper;
import com.yimoo.smartcampussystemdemo.pojo.Admin;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import com.yimoo.smartcampussystemdemo.service.AdminService;
import com.yimoo.smartcampussystemdemo.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @ClassName: AdminServiceImpl
 * @Author: yimoorua
 * @Date: 2022/10/8 17:08
 * @Description:
 * @Version: 1.0
 **/
@Service("adminServiceImpl")
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin login(LoginForm loginForm) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper();
        //与数据库字段进行比较
        queryWrapper.eq("name", loginForm.getUsername());
        //用MD5将明文转密文进行比较
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Admin admin = baseMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public IPage<Admin> getAllAdmin(Page<Admin> pageParam, String adminName) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(adminName)){
            queryWrapper.like("name",adminName);
        }
        Page<Admin> page=baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }


}
