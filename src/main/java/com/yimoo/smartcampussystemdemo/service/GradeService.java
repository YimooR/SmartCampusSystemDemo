package com.yimoo.smartcampussystemdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yimoo.smartcampussystemdemo.pojo.Grade;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GradeService extends IService<Grade> {
    //分页和模糊查询功能
    IPage<Grade> getGradeByOpr(Page<Grade> page, String gradeName);

    List<Grade> getGrades();
}
