package com.htl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {

    //请求链接：http://localhost:8080/target
    @RequestMapping(value = "/target")
    public ModelAndView show(){
        System.out.println("目标资源执行......");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","htl");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}