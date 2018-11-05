package com.sys.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sys.service.UserService;

public class TestAOP {
    @Test
    public void m01() {
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml"); 
    	UserService userService=context.getBean(UserService.class);
    	userService.addUser();
    	userService.delUser();
    	
    }
}
