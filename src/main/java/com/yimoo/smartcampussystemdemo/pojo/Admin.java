package com.yimoo.smartcampussystemdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Admin
 * @Author: yimoorua
 * @Date: 2022/10/7 17:21
 * @Description:
 * @Version: 1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("tb_admin")
public class Admin {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String portraitPath;
}
