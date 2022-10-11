package com.yimoo.smartcampussystemdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yimoo.smartcampussystemdemo.pojo.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClazzService extends IService<Clazz> {


    IPage<Clazz> getClazzByOpr(Page<Clazz> page, Clazz clazz);

    List<Clazz> getClazzs();
}
