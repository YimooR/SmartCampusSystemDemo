package com.yimoo.smartcampussystemdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimoo.smartcampussystemdemo.mapper.StudentMapper;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import com.yimoo.smartcampussystemdemo.pojo.Student;
import com.yimoo.smartcampussystemdemo.service.StudentService;
import com.yimoo.smartcampussystemdemo.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @ClassName: StudentServiceImpl
 * @Author: yimoorua
 * @Date: 2022/10/8 17:13
 * @Description:
 * @Version: 1.0
 **/
@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));
        Student student = baseMapper.selectOne(queryWrapper);
        return student;
    }

    @Override
    public IPage<Student> getStudentByOpr(Page<Student> pageParam, Student student) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        String name = student.getName();
        String clazzName = student.getClazzName();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(clazzName)) {
            queryWrapper.like("clazz_name", clazzName);
        }
        queryWrapper.orderByAsc("id");
        Page<Student> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
