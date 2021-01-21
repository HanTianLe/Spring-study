package com.htl.factory;

import com.htl.dao.UserDao;
import com.htl.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        System.out.println("执行了工厂实例方法");
        return new UserDaoImpl();
    }
}
