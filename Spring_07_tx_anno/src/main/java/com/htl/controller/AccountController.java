package com.htl.controller;

import com.htl.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) app.getBean("accountService");
        accountService.transfer("Tom","Jerry",50);
    }
}
