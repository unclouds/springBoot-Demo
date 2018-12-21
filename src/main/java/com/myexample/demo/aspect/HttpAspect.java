package com.myexample.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {


    private static final Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.myexample.demo.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取请求
        ServletRequestAttributes servletRequestAttributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest= servletRequestAttributes.getRequest();

        //url
        logger.info("url={}",httpServletRequest.getRequestURL());

        //method
        logger.info("method={}",httpServletRequest.getMethod());

        //ip
        logger.info("ip={}",httpServletRequest.getRemoteAddr());

        //class method
        logger.info("class method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //args
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("This is my after");
    }

    //返回
    @AfterReturning(returning = "object",pointcut = "log()")
    public void AReturning(Object object){
        logger.info("return={}",object);

    }
}
