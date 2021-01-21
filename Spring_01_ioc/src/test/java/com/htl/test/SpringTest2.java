package com.htl.test;

import com.htl.dao.UserDao;
import com.htl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {

    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao"); //方法一
//        UserDao userDao = app.getBean(UserDao.class); //方法二
        userDao.save();
    }

    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        /** 普通 */
//        UserService userService = app.getBean("userService", UserService.class);
//        userService.save();
        /** set注入 */
//        UserService userService = app.getBean("userService1", UserService.class);
//        userService.save1();
        /** P命名空间注入（本质就是set注入）*/
//        UserService userService = app.getBean("userService2", UserService.class);
//        userService.save1();
        /** 构造方法注入 */
        UserService userService = app.getBean("userService3", UserService.class);
        userService.save2();
        //当时使用set注入、P命名空间注入、构造方法注入时，
        //这样写会报空指针异常，原因是这边的 userService 是 new 出来的，不是从IoC容器中拿出来的。自然是空。
        //UserService userService = new UserServiceImpl();
        //userService.save();
    }

    @Test
    public void test3(){
        //普通数据类型注入
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = app.getBean("userDao9", UserDao.class);
        userDao.save1();
    }

    @Test
    public void test4(){
        //集合注入
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = app.getBean("userDao10", UserDao.class);
        userDao.save2();
    }

}
