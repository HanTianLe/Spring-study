package com.htl.comtroller;

import com.htl.domain.Account;
import com.htl.domain.Account2;
import com.htl.domain.Account3;
import com.htl.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/test1")
    public String testParam(String username,String password){
        System.out.println("执行了该方法");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success2";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了saveAccount方法。。");
        System.out.println(account);
        return "success2";
    }

    @RequestMapping("/saveAccount2")
    public String saveAccount2(Account2 account2){
        System.out.println("执行了saveAccount2方法。。");
        System.out.println(account2);
        return "success2";
    }

    @RequestMapping("/saveAccount3")
    public String saveAccount3(Account3 account3){
        System.out.println("执行了saveAccount2方法。。");
        System.out.println(account3);
        return "success2";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User2 user2){
        System.out.println("执行了saveUser方法。。");
        System.out.println(user2);
        return "success2";
    }

}
