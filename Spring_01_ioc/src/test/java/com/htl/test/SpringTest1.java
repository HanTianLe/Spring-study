package com.htl.test;

import com.htl.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {
    @Test
    //测试scope属性
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao1 = (UserDao) app.getBean("userDao1");//singleton
//        UserDao userDao2 = (UserDao) app.getBean("userDao1");//singleton
        UserDao userDao1 = app.getBean("userDao2", UserDao.class);//prototype
        UserDao userDao2 = app.getBean("userDao2", UserDao.class);//prototype
        System.out.println(userDao1);
        System.out.println(userDao2);
        //scope="singleton"时，为true
        //scope="prototype"时，为false
        System.out.println(userDao1==userDao2);
    }

    @Test
    //测试 init-method 和 destroy-method
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        System.out.println(userDao);
        //PS：之所以控制台没有打印destroy方法里面的 “销毁方法。。。” 文字，是因为没有来得及打印。
    }

    @Test
    //测试 factory-method   工厂静态方法实例化
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao3");
        System.out.println(userDao);
    }

    @Test
    //测试 factory-method   工厂实例方法实例化
    public void test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao4");
        System.out.println(userDao);
    }

}
