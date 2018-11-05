package com.sys.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

	@Override
	public void addUser() {
		System.out.println("添加用户");
		
	}

	@Override
	public void delUser() {
		System.out.println("删除用户");
		
	}

	

	

}
