package com.yimoo.smartcampussystemdemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MybatisPlusConfig
 * @Author: yimoorua
 * @Date: 2022/10/8 16:12
 * @Description:
 * @Version: 1.0
 **/

@Configuration
@MapperScan("com.yimoo.smartcampussystemdemo.mapper")
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        return paginationInterceptor;
    }
}
