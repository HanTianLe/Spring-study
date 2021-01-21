package com.htl.controller;

import com.htl.exception.MyException;
import com.htl.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

@Controller
public class DemoController {

    @Resource(name = "demoService")//也可以用@Autowired
    private DemoService demoService;

    //访问链接：http://localhost:8080/show
    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        //选择分别选择下面5种异常测试
//        demoService.show1();  //抛出类型转换异常......
//        demoService.show2();  //抛出除零异常......
//        demoService.show3();  //文件找不到异常......
//        demoService.show4();  //空指针异常......
//        demoService.show5();  //自定义异常......
        return "index";
    }
}
