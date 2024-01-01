package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
//设置实体类所对应的表名
//@TableName("t_user")
public class User {
    //将属性所对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    //@TableId注解的type属性用于设置主键生成策略
    @TableId(value = "uid", type = IdType.AUTO)
    private Long id;
    //private Long uid;

    //指定属性所对应的字段名
    @TableField("user_name")
    private String name;
    //private String userName;

    private int age;

    private String email;

    @TableLogic
    private Integer isDeleted;
}
