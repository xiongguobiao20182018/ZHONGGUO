package com.sys.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbc {
    @Test
    public void m01() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("springJDBC.xml");
    	JdbcTemplate jdbc=context.getBean(JdbcTemplate.class);
    	String sql="select * from smbms_user";
    	List<Map<String,Object>> list=jdbc.queryForList(sql);
    	for(Map<String,Object> map:list) {
    		System.out.println(map);
    	}
    }
}
