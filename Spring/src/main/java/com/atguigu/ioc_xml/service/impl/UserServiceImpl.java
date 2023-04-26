package com.atguigu.ioc_xml.service.impl;

import com.atguigu.ioc_xml.dao.UserDao;
import com.atguigu.ioc_xml.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }
}
