package com.htl.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.htl.config.SpringConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    //测试[手动]创建c3p0数据源
    public void Test1(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("password");
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //测试[手动]创建druid数据源
    public void Test2(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //测试[手动]创建c3p0数据源（加载properties配置文件）
    public void Test3(){
        //读取配置文件
        ResourceBundle rs = ResourceBundle.getBundle("jdbc");
        String driver = rs.getString("jdbc.driver");
        String url = rs.getString("jdbc.url");
        String username = rs.getString("jdbc.username");
        String password = rs.getString("jdbc.password");
        //创建数据源对象，设置连接参数
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            //归还数据源
            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //测试[手动]创建druid数据源（加载properties配置文件）
    public void Test4(){
        //读取配置文件
        ResourceBundle rs = ResourceBundle.getBundle("jdbc");
        String driver = rs.getString("jdbc.driver");
        String url = rs.getString("jdbc.url");
        String username = rs.getString("jdbc.username");
        String password = rs.getString("jdbc.password");
        //创建数据源对象，设置连接参数
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            //归还数据源
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //测试[手动]创建c3p0数据源（Spring容器产生数据源对象）
    public void Test5(){
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DataSource dataSource = (DataSource) app.getBean("dataSource_c3p0");
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //测试[手动]创建druid数据源（Spring容器产生数据源对象）
    public void Test6(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource_druid");
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}