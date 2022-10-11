package com.yimoo.smartcampussystemdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yimoo.smartcampussystemdemo.pojo.Student;
import com.yimoo.smartcampussystemdemo.service.StudentService;
import com.yimoo.smartcampussystemdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: StudentCotroller
 * @Author: yimoorua
 * @Date: 2022/10/8 17:19
 * @Description:
 * @Version: 1.0
 **/

@Api(tags = "学生管理控制器")
@RestController
@RequestMapping("/sms/studentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // /sms/studentController/getStudentByOpr/1/3
    @ApiOperation("学生分页并模糊查询名字")
    @RequestMapping(value = "/getStudentByOpr/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Result getStudentByOpr(
            @ApiParam("分页页号")
            @PathVariable("pageNo")Integer pageNo,
            @ApiParam("分页页数")
            @PathVariable("pageSize")Integer pageSize,
            @ApiParam("Json格式的student实体类")
            Student student
    ){
        Page<Student> page=new Page<>(pageNo,pageSize);
        IPage<Student> iPage =studentService.getStudentByOpr(page,student);
        return Result.ok(iPage);
    }



    // /sms/studentController/addOrUpdateStudent
    @ApiOperation("新增或者修改学生信息")
    @RequestMapping(value = "/addOrUpdateStudent",method = RequestMethod.POST)
    public Result addOrUpdateStudent(
            @ApiParam
            @RequestBody Student student
    ){
        studentService.saveOrUpdate(student);
        return Result.ok();
    }

    // /sms/studentController/delStudentById
    @ApiOperation("单个或者批量删除学生信息")
    @RequestMapping(value = "/delStudentById",method = RequestMethod.DELETE)
    public Result delStudentById(
            @ApiParam
            @RequestBody List<Integer> ids
    ){
        studentService.removeByIds(ids);
        return Result.ok();
    }
}
