package com.sys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import com.sys.pojo.Role;

public class RoleMapperTest {
	private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;
    static {
    	try {
			reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //获取所有角色
    @Test
    public void getRoleList() {
		SqlSession session=sqlSessionFactory.openSession();
		String sql="com.sys.mapper.RoleMapper.getRoleList";
		List<Role> list=null;
		list=session.selectList(sql);
		for(Role r:list) {
			System.out.println(r);
		}
	}
}
