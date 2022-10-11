package com.yimoo.smartcampussystemdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yimoo.smartcampussystemdemo.pojo.LoginForm;
import com.yimoo.smartcampussystemdemo.pojo.Teacher;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TeacherService
 * @Author: yimoorua
 * @Date: 2022/10/8 17:07
 * @Description:
 * @Version: 1.0
 **/

public interface TeacherService extends IService<Teacher> {
    Teacher login(LoginForm loginForm);

    IPage<Teacher> getTeacherByOpr(Page<Teacher> page, Teacher teacher);
}
