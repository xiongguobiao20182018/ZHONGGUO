package com.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sys.dao.UserDao;
import com.sys.util.SysLogger;
@Component
public class UserServiceImpl implements UserService{
	@Autowired
   UserDao userDao;

@Override
public void addUser() {
	//SysLogger.before();
	userDao.addUser();
	//SysLogger.after();
}

@Override
public void delUser() {
	//SysLogger.before();
	userDao.delUser();
	//SysLogger.after();
	
}


}
