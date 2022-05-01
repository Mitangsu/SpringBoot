package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Su
 * @create 2022-04-28 22:43
 */
//@TableName() 括号填写表名
@Data
@ToString
public class User {
    /**
     * 所有属性都应该在数据库中
     */
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}

















