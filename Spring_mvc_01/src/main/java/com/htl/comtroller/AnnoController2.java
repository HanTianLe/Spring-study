package com.htl.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/anno2")
@SessionAttributes(value = {"msg"}) //把 msg=张三 存入到session域对象中
public class AnnoController2 {
    /**
     * @SessionAttributes注解
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("执行了testSessionAttributes方法。。。");
        //底层会存储到request域对象中
        model.addAttribute("msg","张三");
        return "success3";
    }

    /**
     * 从Session域取值
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("执行了getSessionAttributes方法。。。");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success3";
    }

    /**
     * 清除Session域
     */
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status){
        System.out.println("执行了deleteSessionAttributes方法。。。");
        status.setComplete();
        return "success3";
    }

}
