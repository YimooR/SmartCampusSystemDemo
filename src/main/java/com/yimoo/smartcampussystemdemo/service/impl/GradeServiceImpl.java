package com.yimoo.smartcampussystemdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yimoo.smartcampussystemdemo.mapper.GradeMapper;
import com.yimoo.smartcampussystemdemo.pojo.Grade;
import com.yimoo.smartcampussystemdemo.service.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName: GradeServiceImpl
 * @Author: yimoorua
 * @Date: 2022/10/8 17:12
 * @Description:
 * @Version: 1.0
 **/
@Service("gradeServiceImpl")
@Transactional
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {
    @Override
    public IPage<Grade> getGradeByOpr(Page<Grade> pageParam, String gradeName) {
        QueryWrapper queryWrapper=new QueryWrapper<>();
        if(!StringUtils.isEmpty(gradeName)){
            queryWrapper.like("name",gradeName);
        }
        queryWrapper.orderByAsc("id");
        Page page=baseMapper.selectPage(pageParam,queryWrapper);
        return page;
    }

    @Override
    public List<Grade> getGrades() {
        return baseMapper.selectList(null);
    }
}
