package com.htl.service.impl;

import com.htl.dao.AccountDao;
import com.htl.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService")
@Transactional(isolation = Isolation.REPEATABLE_READ)   //表明当前类下所有方法都用该事务控制的参数。
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    //或者使用这个：@Autowired（局限于同类型单个）
    private AccountDao accountDao;

    /**
     * 转账
     * @param outMan 汇款人
     * @param inMan  收款人
     * @param money  收款金额
     */
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    //当方法与[方法所在类]的@Transactional冲突时，采用【就近原则】，使用方法上的事务控制参数。
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int i = 1/0;
        accountDao.in(inMan, money);
    }
}
