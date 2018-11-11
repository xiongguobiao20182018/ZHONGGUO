package com.sys.dao;

import java.util.List;

import com.sys.model.Master;

public interface MasterDao {
    public Master login(String name);
	
	public int delete(int id);
	public int Update(String name,String password,int id);
	public int add(String name,String password,int id);
	
    public List<Master> getAllMaster();
	
	//模糊查询
	public List<Master> getMasterByInfo(Master master);
	public int updateMoney(int money,int id);
}
