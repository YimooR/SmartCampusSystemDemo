package com.yimoo.smartcampussystemdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimoo.smartcampussystemdemo.mapper.ClazzMapper;
import com.yimoo.smartcampussystemdemo.pojo.Clazz;
import com.yimoo.smartcampussystemdemo.service.ClazzService;
import freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName: ClazzServiceImpl
 * @Author: yimoorua
 * @Date: 2022/10/8 17:11
 * @Description:
 * @Version: 1.0
 **/
@Service("clazzServiceImpl")
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

    @Override
    public IPage<Clazz> getClazzByOpr(Page<Clazz> pageParam, Clazz clazz) {
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<Clazz>();
        String gradeName=clazz.getGradeName();
        String name=clazz.getName();
        if(!StringUtils.isEmpty(gradeName)){
            queryWrapper.like("grade_name",gradeName);
        }
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        queryWrapper.orderByAsc("id");
        Page page=baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }

    @Override
    public List<Clazz> getClazzs() {
        return baseMapper.selectList(null);
    }
}
