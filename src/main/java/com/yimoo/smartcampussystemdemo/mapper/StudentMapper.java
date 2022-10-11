package com.yimoo.smartcampussystemdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yimoo.smartcampussystemdemo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: StudentMapper
 * @Author: yimoorua
 * @Date: 2022/10/8 16:53
 * @Description:
 * @Version: 1.0
 **/

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
