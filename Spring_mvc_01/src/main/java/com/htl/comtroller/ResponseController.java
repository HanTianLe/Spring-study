package com.htl.comtroller;

import com.htl.domain.User3;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/response")
public class ResponseController {

    /**
     * 响应返回值是String类型
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了。。。");
        //模拟从数据库中查询出User3对象
        User3 user3 = new User3();
        user3.setUsername("张三");
        user3.setPassword("123");
        user3.setAge(18);
        //model对象
        model.addAttribute("user3",user3);
        return "success4";
    }

    /**
     * 响应返回值是void类型
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了。。。");
        //请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success4.jsp").forward(request,response);

        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行响应
        response.getWriter().print("你好 世界~");

        return;
    }

    /**
     * 响应返回值是ModelAndView类型
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("执行了testModelAndView方法。。。");
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //模拟从数据库中查询出User对象
        User3 user3 = new User3();
        user3.setUsername("赵六");
        user3.setPassword("666");
        user3.setAge(12);
        //把user3对象存储到modelAndView对象中，也会把user3对象存入到request对象当中。
        modelAndView.addObject("user3",user3);
        //跳转到那个页面
        modelAndView.setViewName("success4");
        return modelAndView;
    }

    /**
     * 响应返回值是forward进行页面跳转
     */
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("执行了testForward方法。。。");
        //请求的转发
        return "forward:/WEB-INF/pages/success4.jsp";
    }

    /**
     * 响应返回值是redirect进行页面跳转
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("执行了testRedirect方法。。。");
        //重定向
        return "redirect:/index.jsp";
    }

}

