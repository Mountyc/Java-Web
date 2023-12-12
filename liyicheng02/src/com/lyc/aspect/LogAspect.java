package com.lyc.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;


@Component("logAspect")
@Aspect//把当前类配置称为一个切面
public class LogAspect {

    @Pointcut("execution(* com.lyc.service.impl.*.*(..))")
    private void ptr() {

    }
    /**
     *  前置通知
     */
    @Before("ptr()")
    public void beforePrintLog() {
        System.out.println("LogAspect类beforePrintLog方法中的log日志打印开始..");
    }
    /**
     *  后置通知
     */
    @AfterReturning("ptr()")
    public void afterReturnPrintLog() {
        System.out.println("LogAspect类afterReturnPrintLog方法中的log日志打印开始了..");
    }

    /**
     *  异常通知
     */
    @AfterThrowing("ptr()")
    public void afterThrowingPrintLog() {
        System.out.println("LogAspect类afterThrowingPrintLog方法中的log日志打印开始了..");
    }
    /**
     *  最终通知
     */
    @After("ptr()")
    public void afterPrintLog() {
        System.out.println("LogAspect类afterPrintLog方法中的log日志打印开始了..");
    }
}
