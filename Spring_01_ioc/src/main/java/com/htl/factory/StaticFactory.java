package com.htl.factory;

import com.htl.dao.UserDao;
import com.htl.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        System.out.println("执行了工厂静态方法");
        return new UserDaoImpl();
    }
}
