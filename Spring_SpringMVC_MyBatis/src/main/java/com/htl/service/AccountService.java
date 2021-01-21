package com.htl.service;

import com.htl.domain.Account;

import java.util.List;

public interface AccountService {

    public void save(Account account);

    public List<Account>findAll();

}
