package com.htl.comtroller;

import com.htl.domain.User3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {
    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body){
        System.out.println("执行了testAjax方法。。。");
        System.out.println(body);
    }

    /**
     * 响应json格式数据
     */
    @RequestMapping("/testJSON")
    public @ResponseBody User3 testJSON(@RequestBody User3 user3){
        System.out.println("执行了testJson方法。。。");
        //客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user3对象中
        System.out.println(user3);
        //做响应，模拟查询数据库
        user3.setUsername("张三");
        user3.setAge(20);
        return user3;
    }

}
