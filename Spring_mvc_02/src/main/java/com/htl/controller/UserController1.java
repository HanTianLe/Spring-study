package com.htl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class UserController1 {
    /**
     *  拦截器
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor方法执行了、、、");
        return "success";
    }

}
