package com.yimoo.smartcampussystemdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Grade
 * @Author: yimoorua
 * @Date: 2022/10/7 17:30
 * @Description:
 * @Version: 1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("tb_grade")
public class Grade {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String manager;
    private String email;
    private String telephone;
    private String introducation;
}
