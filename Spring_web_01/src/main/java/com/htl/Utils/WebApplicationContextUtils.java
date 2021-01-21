package com.htl.Utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

//自定义的WebApplicationContextUtils
public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
