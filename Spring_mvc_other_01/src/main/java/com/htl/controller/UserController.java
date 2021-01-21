package com.htl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htl.domain.User;
import com.htl.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    //请求地址：http://localhost:8080/user/quick
    @RequestMapping(value = "/quick")
    public String save(){
        System.out.println("Controller save running......");
        return "success2";
    }

    //请求地址：http://localhost:8080/user/quick2
    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /**
         *  Model:模型 作用封装数据
         *  View：视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","htl");
        //设置视图名称
        modelAndView.setViewName("success2");
        return modelAndView;
    }

    //请求地址：http://localhost:8080/user/quick3
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        /**
         * SpringMVC能为方法的参数进行相应的注入，
         * 当解析方法时，发现参数有ModelAndView需要SpringMVC框架提供，
         * 那么SpringMVC会自动提供一个ModelAndView对象供使用。
         */
        //设置模型数据
        modelAndView.addObject("username","韩天乐");
        //设置视图名称
        modelAndView.setViewName("success2");
        return modelAndView;
    }

    //请求地址：http://localhost:8080/user/quick4
    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        /**
         * 该对象也是由SpringMVC提供
         */
        //设置模型数据
        model.addAttribute("username","呵呵");
        return "success2";
    }

    //请求地址：http://localhost:8080/user/quick5
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        /**
         * 这边的request就是原生的JavaWeb的对象。（这种方法不常用！）
         */
        //设置模型数据
        request.setAttribute("username","哈哈");
        return "success2";
    }

    //请求地址：http://localhost:8080/user/quick6
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello World~");
    }

    //请求地址：http://localhost:8080/user/quick7
    @RequestMapping(value = "/quick7")
    @ResponseBody   //告知SpringMVC框架，不进行视图跳转，直接进行数据响应。
    public String save7(){
        return "Hei Man~";
    }

    //请求地址：http://localhost:8080/user/quick8
    //模拟返回JSON数据_1
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8(){
        return "{\"username\":\"HTL\",\"age\":20}";
    }

    //请求地址：http://localhost:8080/user/quick9
    //模拟返回JSON数据_2
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("Force");
        user.setAge(24);
        //使用json的转换工具将对象转换成json格式字符串再返回。
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    //请求地址：http://localhost:8080/user/quick10
    @RequestMapping(value = "/quick10")
    @ResponseBody
    //返回对象
    public User save10(){
        User user = new User();
        user.setUsername("Luck");
        user.setAge(200);
        //期望SpringMVC自动将User对象转换成json格式的字符串
        //就需要配置处理器映射器
        return user;
    }

    //请求地址：http://localhost:8080/user/quick11
    @RequestMapping(value = "/quick11")
    @ResponseBody
    //返回集合
    public Set<String> save11(){
        Set<String> set = new HashSet<>();
        set.add("hello world");
        set.add("HTL");
        return set;
    }

    //请求地址：http://localhost:8080/user/quick12?username=zhangsan&age=20
    //获得基本类型参数
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    //请求地址：http://localhost:8080/user/quick13?username=lisi&age=22
    //获得POJO类型参数
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(User user){
        System.out.println(user);
    }

    //请求地址：http://localhost:8080/user/quick14?strs=aaa&strs=bbb&strs=ccc
    //获得数组类型参数
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(String[] strs){
        System.out.println(Arrays.asList(strs));
    }

    //请求地址：http://localhost:8080/form.jsp
    //获得集合类型参数_1
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(VO vo){
        System.out.println(vo);
    }

    //请求地址：http://localhost:8080/ajax.jsp
    //获得集合类型参数_2
    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    //请求地址：http://localhost:8080/user/quick17
    //请求地址：http://localhost:8080/user/quick17?name=韩天乐
    //参数绑定注解@RequestParam
    @RequestMapping(value = "/quick17")
    @ResponseBody //将浏览器请求的参数name映射到username这个参数上
    public void save17(@RequestParam(value = "name",required = false,defaultValue = "呵呵") String username){
        System.out.println(username);
    }

    //请求地址：http://localhost:8080/user/quick18/韩天乐
    //获得Restful风格的参数
    @RequestMapping(value = "/quick18/{name}")
    @ResponseBody
    public void save18(@PathVariable(value = "name",required = true) String name){
        System.out.println(name);
    }

    //请求地址：http://localhost:8080/user/quick19?date=2020-8-18
    //自定义类型转换器
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(Date date){
        System.out.println(date);
    }

    //请求地址：http://localhost:8080/user/quick20
    //获得Servlet相关API
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    //请求地址：http://localhost:8080/user/quick21
    //@RequestHeader
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@RequestHeader(value = "User-Agent" ,required = false) String user_agent){
        System.out.println(user_agent);
    }

    //请求地址：http://localhost:8080/user/quick22
    //@CookieValue
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
    }

    //请求地址：http://localhost:8080/upload.jsp
    //文件上传
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username,MultipartFile uploadFile,MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        //设置文件存放位置
        uploadFile.transferTo(new File("E:\\教学视频\\【学习笔记】\\Spring【学习笔记】\\"+originalFilename));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("E:\\教学视频\\【学习笔记】\\Spring【学习笔记】\\"+originalFilename2));
    }

    //请求地址：http://localhost:8080/upload.jsp
    //文件上传
    @RequestMapping(value = "/quick24")
    @ResponseBody
    public void save24(String username,MultipartFile[] uploadFile) throws IOException{
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile){
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("E:\\教学视频\\【学习笔记】\\Spring【学习笔记】\\"+originalFilename));
        }
    }

}