package com.htl.service.impl;

import com.htl.dao.AccountDao;
import com.htl.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账
     * @param outMan 汇款人
     * @param inMan  收款人
     * @param money  收款金额
     */
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan, money);
        int i = 1/0;
        accountDao.in(inMan, money);
    }
}
