package com.htl.service;

import com.htl.domain.Account;

import java.util.List;

public interface AccountService {

    void save(Account account);

    List<Account>findAll();

}
