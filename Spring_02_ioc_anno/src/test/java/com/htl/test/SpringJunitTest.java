package com.htl.test;

import com.htl.config.SpringConfiguration;
import com.htl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**     Spring 集成 Junit     */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")     //xml文件配置时使用
@ContextConfiguration(classes = {SpringConfiguration.class})    //全注解时使用
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    //@Autowired //使用在字段上用于根据【类型】依赖注入，无法准确定位 同类型多个。
    //因为DataSourceConfiguration里面有两个DataSource类型的方法，使用这个更能准确的定位。
    @Resource(name = "dataSource_druid")
    private DataSource dataSource;

    /**
     *  通常使用 Junit 都要写：
     *  ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
     *  UserService userService = (UserService) app.getBean("userService");
     *  当使用了 Spring 集成 Junit 后，就可以省略了。
     */
    @Test
    public void test1() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }

}
