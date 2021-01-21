package com.htl.dao.impl;

import com.htl.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    //或者使用这个：@Autowired（局限于同类型单个）
    private JdbcTemplate jdbcTemplate;

    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money = money - ? where name = ?",
                money,outMan);
    }

    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money = money + ? where name=?",
                money,inMan);
    }
}
