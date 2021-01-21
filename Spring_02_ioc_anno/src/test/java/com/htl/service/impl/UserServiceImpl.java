package com.htl.service.impl;

import com.htl.dao.UserDao;
import com.htl.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.htl.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("淮安")    //注入普通属性
    private String address;
    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"/>
    //@Autowired            //按照数据类型从Spring容器中进行匹配（仅可当[所要使用的数据类型]有一个的时候使用）
    //@Qualifier("userDao") //是按照id值从容器中进行匹配 但是此处@Qualifier要结合@Autowired一起使用。
    @Resource(name = "userDao")//@Resource相当于@Autowired+@Qualifier
    private UserDao userDao;

    //通过xml配置文件将userDao注入到userService中需要写setXxx方法，而通过注释则不需要了。
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        System.out.println(address);
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct//Bean的初始化方法
    public void init(){
        System.out.println("Service对象初始化方法。。。");
    }

    @PreDestroy//Bean的销毁方法
    public void destroy(){
        System.out.println("Service对象销毁方法。。。");
    }

}
