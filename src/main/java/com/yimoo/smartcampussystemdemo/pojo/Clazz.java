package com.yimoo.smartcampussystemdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Clazz
 * @Author: yimoorua
 * @Date: 2022/10/7 17:23
 * @Description:
 * @Version: 1.0
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("tb_clazz")
public class Clazz {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    private String name;
    private Integer number;
    private String introducation;
    private String headmaster;
    private String email;
    private String telephone;
    private String gradeName;
}
