package com.yimoo.smartcampussystemdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import com.yimoo.smartcampussystemdemo.pojo.Student;
import org.springframework.stereotype.Service;


public interface StudentService extends IService<Student> {
    Student login(LoginForm loginForm);

    IPage<Student> getStudentByOpr(Page<Student> page, Student student);
}
