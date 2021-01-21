package com.htl.service.impl;

import com.htl.dao.UserDao;
import com.htl.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    /** 普通 */
    public void save() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = app.getBean("userDao5", UserDao.class);
        userDao.save();
    }

    /** set注入 */
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save1() {
        userDao.save();
    }

    /** 构造方法注入 */
    private UserDao userDao2;
    public UserServiceImpl(UserDao userDao) {
        this.userDao2 = userDao;
    }
    public UserServiceImpl() { }
    public void save2() {
        userDao2.save();
    }

}
