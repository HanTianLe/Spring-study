package com.htl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {

    //在目标方法执行之前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle......");
        String param = request.getParameter("param");
        if ("yes".equals(param)){
            return true;        //携带参数param如果是yes，则通过
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;       //携带参数param如果不是yes，则被拦截，且跳转到error.jsp页面
        }
    }

    //在目标方法执行之后 视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","May");
        //在TargetController类的show()方法里，原先设置了"name","htl"键值对。
        //返回视图对象前，执行了这边的postHandle方法。又设置了"name","May"键值对，把原来的覆盖了。
        //所有index.jsp返回的name是May。
        System.out.println("postHandle......");
    }

    //在流程都执行完毕后 执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion......");
    }
}