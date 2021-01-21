package com.htl.dao.impl;

import com.htl.dao.UserDao;
import com.htl.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建。。。");
    }
    public void init(){
        System.out.println("初始化方法。。。");
    }
    public void save() {
        System.out.println("save is running...");
    }
    public void destroy(){
        System.out.println("销毁方法。。。");
    }

    /** 普通数据类型注入 */
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void save1() {
        System.out.println(username+"==="+age);
        System.out.println("save1 is running...");
    }

    /** 集合注入 */
    private List<String> strList;       // list集合
    private Map<String, User> userMap;  // Map集合
    private Properties properties;      // Properties

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }
    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void save2() {
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save2 is running...");
    }

}
