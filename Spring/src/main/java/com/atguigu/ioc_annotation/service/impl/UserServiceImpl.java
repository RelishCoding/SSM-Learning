package com.atguigu.ioc_annotation.service.impl;

import com.atguigu.ioc_annotation.dao.UserDao;
import com.atguigu.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //@Autowired(required = false)
    @Autowired
    //@Qualifier("userDaoImpl")
    //@Qualifier("dao")
    private UserDao userDao;

    public void saveUser() {
        userDao.saveUser();
    }
}
