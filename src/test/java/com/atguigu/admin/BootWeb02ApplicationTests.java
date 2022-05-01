package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class BootWeb02ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;




    @Test
    void contextLoads() {

//        jdbcTemplate.queryForObject("select * from user");
//        jdbcTemplate.queryForList("select * from user");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println(aLong);
        log.info("记录总数:{}",aLong);
        log.info("数据源类型:{}",dataSource.getClass());

    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用户信息:{}",user);
    }

    @Test
    void testUserMapper1(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }





}
