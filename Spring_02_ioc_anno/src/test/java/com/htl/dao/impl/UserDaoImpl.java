package com.htl.dao.impl;

import com.htl.dao.UserDao;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.htl.dao.impl.UserDaoImpl"/>
//@Component("userDao")   //使用在类上，实例化Bean
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save is running...");
    }
}