package com.yimoo.smartcampussystemdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yimoo.smartcampussystemdemo.pojo.Admin;
import com.yimoo.smartcampussystemdemo.service.AdminService;
import com.yimoo.smartcampussystemdemo.util.MD5;
import com.yimoo.smartcampussystemdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: AdminController
 * @Author: yimoorua
 * @Date: 2022/10/8 16:46
 * @Description:
 * @Version: 1.0
 **/

@Api(tags = "管理员控制器")
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    // /sms/adminController/getAllAdmin/1/3?adminName=
    @ApiOperation("分页并模糊查询管理员姓名")
    @RequestMapping(value = "/getAllAdmin/{pageNo}/{pageSize}",method = RequestMethod.GET)
    public Result getAllAdmin(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            String adminName
            ){
        Page<Admin> page=new Page<>(pageNo,pageSize);
        IPage<Admin> iPage =adminService.getAllAdmin(page,adminName);
        return Result.ok(iPage);
    }

    // /sms/adminController/saveOrUpdateAdmin
    @ApiOperation("保存并更改管理员信息")
    @RequestMapping(value = "/saveOrUpdateAdmin",method = RequestMethod.POST)
    public Result saveOrUpdateAdmin(
            @ApiParam("json格式的admin对象")
            @RequestBody Admin admin
    ){
        String password=admin.getPassword();
        admin.setPassword(MD5.encrypt(password));
        adminService.saveOrUpdate(admin);
        return Result.ok();
    }

    // /sms/adminController/deleteAdmin
    @ApiOperation("删除单个或者多个id的admin信息")
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.DELETE)
    public Result deleteAdmin(
            @ApiParam("Json格式的ids")
            @RequestBody List<Integer> ids
    ){
        adminService.removeByIds(ids);
        return Result.ok();
    }
}
