package com.yimoo.smartcampussystemdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yimoo.smartcampussystemdemo.pojo.Grade;
import com.yimoo.smartcampussystemdemo.service.GradeService;
import com.yimoo.smartcampussystemdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: GradeController
 * @Author: yimoorua
 * @Date: 2022/10/8 17:18
 * @Description:
 * @Version: 1.0
 **/

@Api(tags = "年级控制器")
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {

    @Autowired
    GradeService gradeService;

    //sms/gradeController/getGrades/1/3?gradeName=%E4%88%89
    @ApiOperation("根据年级名称模糊查询，带分页")
    @RequestMapping(value = "/getGrades/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public Result getGrades(
            @ApiParam("分页查询的页码数")
            @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页大小")
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询模糊匹配的名称")
            String gradeName
    ) {
        //分页带条件查询
        Page<Grade> page = new Page<Grade>(pageNo, pageSize);
        IPage<Grade> iPage = gradeService.getGradeByOpr(page, gradeName);
        //封装Result对象并返回
        return Result.ok(iPage);
    }

    @ApiOperation("保存或新增年级信息，有id属性是修改，没有id属性是增加")
    ///sms/gradeController/saveOrUpdateGrade
    @RequestMapping(value = "/saveOrUpdateGrade", method = RequestMethod.POST)
    public Result saveOrUpdateGrade(
            @ApiParam("JSON的Grade对象")
            @RequestBody Grade grade
    ) {
        gradeService.saveOrUpdate(grade);
        return Result.ok();
    }

    @ApiOperation("删除年级信息")
//    /sms/gradeController/deleteGrade
    @RequestMapping(value = "/deleteGrade", method = RequestMethod.DELETE)
    public Result deleteGrade(
            @ApiParam("id的list集合")
            @RequestBody List<Integer> ids) {
        gradeService.removeByIds(ids);
        return Result.ok();
    }

    //    /sms/gradeController/getGrades
    @ApiOperation("获取全部年级信息")
    @RequestMapping(value = "/getGrades",method = RequestMethod.GET)
    public Result getGrades(){
        List<Grade> grades=gradeService.getGrades();
        return Result.ok(grades);
    }
}
