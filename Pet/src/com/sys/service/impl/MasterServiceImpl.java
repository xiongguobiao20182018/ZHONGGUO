package com.sys.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.dao.BaseDao;
import com.sys.dao.MasterDao;
import com.sys.dao.imple.MasterDaoImpl;
import com.sys.model.Account;
import com.sys.model.Master;
import com.sys.model.Pet;
import com.sys.test.TestMasterDao;

import service.MasterService;

public class MasterServiceImpl implements MasterService{
	private MasterDao masterDao = new MasterDaoImpl();
	private Logger logger = Logger.getLogger(TestMasterDao.class.getName());
	@Override
	public boolean login(Master master) {
		Master m = masterDao.login(master.getName());		
		//3.判断登录信息
		if(m == null){
			System.out.println("账号不存在！");
		}else{
			if(master.getPassword().equals(m.getPassword())){
				System.out.println("登录成功！欢迎："+master.getId());
				return true;
			}else{
				System.out.println("密码错误！");
			}
		}
		return false;
	}
	@Override
	public List<Master> getAllMaster() {
		System.out.println("Service层");
		
		return masterDao.getAllMaster();
	}
	@Override
	public List<Master> getMaster(Master master) {
		
		return masterDao.getMasterByInfo(master);
	}
	@Override
	public List<Pet> getPetsByMasterId(int id) {
		
		return null;
	}
	@Override
	public boolean sallPet(Account account) {
		
		return true;
	}

}
