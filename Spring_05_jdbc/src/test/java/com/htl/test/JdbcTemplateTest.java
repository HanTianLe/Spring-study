package com.htl.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    //测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_study?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("password");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        //执行添加操作
        int row = jdbcTemplate.update("insert into account values(?,?)","Tom",100.2);
        System.out.println(row);
    }

    @Test
    //测试Spring产生jdbcTemplate对象（并抽取jdbc信息）
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        int row = jdbcTemplate.update("insert into account values(?,?)", "Jerry", 200.3);
        System.out.println(row);
    }

}