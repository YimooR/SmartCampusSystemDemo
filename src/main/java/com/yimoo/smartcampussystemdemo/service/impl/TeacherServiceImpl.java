package com.yimoo.smartcampussystemdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimoo.smartcampussystemdemo.mapper.TeacherMapper;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import com.yimoo.smartcampussystemdemo.pojo.Teacher;
import com.yimoo.smartcampussystemdemo.service.TeacherService;
import com.yimoo.smartcampussystemdemo.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @ClassName: TeacherServiceImpl
 * @Author: yimoorua
 * @Date: 2022/10/8 17:14
 * @Description:
 * @Version: 1.0
 **/
@Service("teacherServiceImpl")
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Teacher teacher=baseMapper.selectOne(queryWrapper);
        return teacher;
    }

    @Override
    public IPage<Teacher> getTeacherByOpr(Page<Teacher> pageParam, Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper=new QueryWrapper();
        String name=teacher.getName();
        String clazzName=teacher.getClazzName();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(clazzName)){
            queryWrapper.like("clazz_name",clazzName);
        }
        queryWrapper.orderByAsc("id");
        Page page=baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }
}
