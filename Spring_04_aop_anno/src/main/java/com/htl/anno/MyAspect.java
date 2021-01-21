package com.htl.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    /** 定义切点表达式 */
    @Pointcut("execution(public void com.htl.anno.Target.save())")
    public void pointcut(){}

    @Before("pointcut()")                   //引用方法1
    public void before(){
        System.out.println("前置增强......");
    }

    @AfterReturning("MyAspect.pointcut()")  //引用方法2
    public void afterReturning(){
        System.out.println("后置增强......");
    }

    @Around("pointcut()")
    //Proceeding JoinPoint：正在执行的连接点===切点
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕前增强....");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强....");
        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出增强");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强....");
    }

}
