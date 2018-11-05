package com.sys.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SysLogger {
	@Before("execution(public void com.sys.service.UserService.del*(..))")//(..)为参数 del*为以del开头的方法名
    public static void before() {
    	System.out.println("....方法调用before的日志记录....");
    }
	@After("execution(public void com.sys.service.UserService.del*(..))")
    public static void after() {
    	System.out.println("....方法调用after的日志记录....");
    }
}
