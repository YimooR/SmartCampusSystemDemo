package com.yimoo.smartcampussystemdemo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yimoo.smartcampussystemdemo.pojo.Clazz;
import com.yimoo.smartcampussystemdemo.service.ClazzService;
import com.yimoo.smartcampussystemdemo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @ClassName: ClazzController
 * @Author: yimoorua
 * @Date: 2022/10/8 16:46
 * @Description:
 * @Version: 1.0
 **/
@Api(tags = "班级管理控制器")
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    // /sms/clazzController/getClazzsByOpr/1/3?gradeName=&name=
    @ApiOperation("分页带条件查询班级信息")
    @RequestMapping(value = "/getClazzsByOpr/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public Result getClazzsByOpr(
            @ApiParam("分页查询的页码数")
            @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页大小")
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询的查询条件")
                    Clazz clazz
    ) {
        Page<Clazz> page = new Page<Clazz>(pageNo, pageSize);
        IPage<Clazz> iPage = clazzService.getClazzByOpr(page, clazz);
        return Result.ok(iPage);
    }

    // /sms/clazzController/saveOrUpdateClazz
    @ApiOperation("更新或新增班级信息")
    @RequestMapping(value = "/saveOrUpdateClazz", method = RequestMethod.POST)
    public Result saveOrUpdateClazz(
            @ApiParam("json中实体对象clazz")
            @RequestBody Clazz clazz) {
        clazzService.saveOrUpdate(clazz);
        return Result.ok();
    }

    // /sms/clazzController/deleteClazz
    @ApiOperation("单个或批量删除班级信息")
    @RequestMapping(value = "/deleteClazz",method = RequestMethod.DELETE)
    public Result deleteClazz(
            @ApiParam("list集合的id")
            @RequestBody List<Integer> ids){
        clazzService.removeByIds(ids);
        return Result.ok();
    }

    // /sms/clazzController/getClazzs
    @RequestMapping(value = "/getClazzs",method = RequestMethod.GET)
    public Result getClazzs(){
        List<Clazz> clazzs=clazzService.getClazzs();
        return Result.ok(clazzs);
    }
}
