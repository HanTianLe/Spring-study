package com.htl.service.impl;

import com.htl.domain.Account;
import com.htl.mapper.AccountMapper;
import com.htl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            mapper.save(account);
//            sqlSession.commit();
//            sqlSession.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        accountMapper.save(account);
    }

    public List<Account> findAll() {
//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//            List<Account> accountList = mapper.findAll();
//            sqlSession.close();
//            return accountList;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
        return accountMapper.findAll();
    }
}
