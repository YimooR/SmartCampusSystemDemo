package com.yimoo.smartcampussystemdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Teacher
 * @Author: yimoorua
 * @Date: 2022/10/8 16:07
 * @Description:
 * @Version: 1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("tb_teacher")
public class Teacher {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String tno;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String portraitPath;
    private String clazzName;
}
