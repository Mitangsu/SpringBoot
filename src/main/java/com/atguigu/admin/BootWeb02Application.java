package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//监听器---》过滤器---》拦截器
@MapperScan("com.atguigu.admin.mapper")
@ServletComponentScan(basePackages = "com.atguigu.damin")
@SpringBootApplication
public class BootWeb02Application {

    public static void main(String[] args) {
        SpringApplication.run(BootWeb02Application.class, args);
    }

}
