package com.htl.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/save")
    public String save(){
        System.out.println("Controller is running~");
        return "success2";
    }

    @RequestMapping(path = "/test")
    @ResponseBody
    public String test(){
        return "Hello~";
    }

    @RequestMapping(path = "/save2")
    public String save2(){
        return "page1";
    }

    @RequestMapping(value = "/save3",params = {"money"})
    @ResponseBody
    public String save3(){
        return "hello~";
    }

    @RequestMapping(value = "/delete",params = {"accountName","money"})
    public String delete(){
        System.out.println("删除了账户");
        return "success2";
    }


}
