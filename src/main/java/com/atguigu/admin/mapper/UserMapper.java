package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Mapper继承该接口后,无需编写mapper.xml文件 ,即可获取CRUD功能
 * @author Su
 * @create 2022-05-01 2:42
 */
public interface UserMapper extends BaseMapper<User> {

}
