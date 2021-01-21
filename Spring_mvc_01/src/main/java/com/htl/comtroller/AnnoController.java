package com.htl.comtroller;

import com.htl.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    /**
     * @RequestParam注解
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了testRequestParam方法。。。");
        System.out.println(username);
        return "success2";
    }

    /**
     * @RequestBody注解
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了testRequestBody方法。。。");
        System.out.println(body);
        return "success2";
    }

    /**
     * @PathVariable注解
     */
    @RequestMapping(value = "/testPathVariable/{ids}",method = RequestMethod.PUT)
    public String testPathVariable(@PathVariable(name = "ids") String id){
        System.out.println("执行了testPathVariable方法。。。");
        System.out.println(id);
        return "success2";
    }

    /**
     * @RequestHeader注解
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了testRequestHeader方法。。。");
        System.out.println(header);
        return "success2";
    }

    /**
     * @CookieValue注解
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了testCookieValue方法。。。");
        System.out.println(cookieValue);
        return "success2";
    }

    /**
     * @ModelAttribute注解
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User2 user2){
        System.out.println("后执行了testModelAttribute方法。。。");
        System.out.println(user2);
        return "success2";
    }
    //该方法会先执行
    @ModelAttribute
    public User2 showUser(String name){
        System.out.println("先执行了showUser方法~~~");
        //通过数据库查询数据（模拟）
        User2 user2 = new User2();
        user2.setName(name);
        user2.setDate(new Date());
        return user2;
    }

    /**
     * @ModelAttribute注解2
     */
    @RequestMapping(value = "/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("abc") User2 user2){
        System.out.println("后执行了testModelAttribute2方法。。。");
        System.out.println(user2);
        return "success2";
    }
    @ModelAttribute
    public void showUser2(String name, Map<String,User2> map){
        System.out.println("先执行了showUser2方法~~~");
        //通过数据库查询数据（模拟）
        User2 user2 = new User2();
        user2.setName(name);
        user2.setDate(new Date());
        map.put("abc",user2);
    }

    
}

