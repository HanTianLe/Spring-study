package com.htl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 【预处理】：controller方法执行前。
     * return true 表示放行，再执行下一个拦截器；如果没有，就执行controller中的方法。
     * return false 表示不放行。
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /** 放行的情况 */
        System.out.println("MyInterceptor111拦截器放行。。。");
        return true;

        /** 不放行的情况 */
//        System.out.println("MyInterceptor111拦截器不放行。。。");
//        //跳转到错误页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;
    }

    /**
     * 【后处理】：controller方法执行后，success.jsp执行之前。
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor111拦截器放行，执行controller方法后执行~~~");
        /** 这边也可以执行页面跳转，如跳转到错误页面。（这样虽然跳转到错误页面，但success.jsp里面的输出依然执行） */
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }

    /**
     * success.jsp页面执行之后，该方法会执行。
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("success.jsp页面执行之后111。。。");
    }

}
