package com.yimoo.smartcampussystemdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yimoo.smartcampussystemdemo.pojo.Teacher;
import com.yimoo.smartcampussystemdemo.service.TeacherService;
import com.yimoo.smartcampussystemdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: TeacherController
 * @Author: yimoorua
 * @Date: 2022/10/8 17:19
 * @Description:
 * @Version: 1.0
 **/

@Api(tags = "教师管理控制器")
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    // /sms/teacherController/getTeachers/1/3?name=&clazzName=

    @ApiOperation("分页显示并模糊查询教师姓名")
    @RequestMapping(value = "/getTeachers/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Result getTeachers(
            @ApiParam("分页页号")
            @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页页数")
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("json格式的教师对象")
            Teacher teacher
            ){
        Page<Teacher> page=new Page<>(pageNo,pageSize);
        IPage<Teacher> iPage =teacherService.getTeacherByOpr(page,teacher);
        return Result.ok(iPage);
    }

    // /sms/teacherController/saveOrUpdateTeacher
    @ApiOperation("更新或者保存教师信息")
    @RequestMapping(value = "/saveOrUpdateTeacher",method = RequestMethod.POST)
    public Result saveOrUpdateTeacher(
            @ApiParam("json格式的teacher对象")
            @RequestBody Teacher teacher
    ){
        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }

    // /sms/teacherController/deleteTeacher
    @ApiOperation("单个或批量删除教师信息")
    @RequestMapping(value = "/deleteTeacher",method = RequestMethod.DELETE)
    public Result deleteTeacher(
            @ApiParam("list集合的id")
            @RequestBody List<Integer> ids
    ){
        teacherService.removeByIds(ids);
        return Result.ok();
    }
}
