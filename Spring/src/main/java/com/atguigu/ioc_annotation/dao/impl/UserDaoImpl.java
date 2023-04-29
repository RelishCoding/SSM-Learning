package com.atguigu.ioc_annotation.dao.impl;

import com.atguigu.ioc_annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("保存成功");
    }
}
