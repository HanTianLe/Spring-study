package com.htl.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常业务逻辑
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取到异常对象
        SysException e = null;
        if (ex instanceof SysException){
            e = (SysException) ex;
        }else {
            e = new SysException("系统正在维护");
        }
        //创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
