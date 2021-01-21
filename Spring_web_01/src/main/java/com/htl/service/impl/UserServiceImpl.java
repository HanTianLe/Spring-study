package com.htl.service.impl;

import com.htl.dao.UserDao;
import com.htl.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save() {
        userDao.save();
    }

}
