package com.htl.test;

import com.htl.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)     //Spring集成Junit来测试
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Resource(name = "jdbcTemplate")
    //@Autowired  //或者使用这个。但这个使用在字段上用于根据【类型】依赖注入，无法准确定位同类型多个。
    private JdbcTemplate jdbcTemplate;

    //测试[修改]操作
    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update account set money = ? where name = ?", 0, "Tom");
        System.out.println(row);
    }

    //测试[删除]操作
    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from account where name = ?", "Tom");
        System.out.println(row);
    }

    //测试[添加]操作
    @Test
    public void testInsert(){
        int row = jdbcTemplate.update("insert into account values(?,?)","Tom",100.2);
        System.out.println(row);
    }

    //测试[查询]操作（查询全部）
    @Test
    public void testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    //测试[查询]操作（查询单个）
    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), "Tom");
        System.out.println(account);
    }

    //测试[查询]操作（查询count）
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

}
