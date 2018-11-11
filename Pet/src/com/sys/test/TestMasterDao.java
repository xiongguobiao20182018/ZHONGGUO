package com.sys.test;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.sys.dao.MasterDao;
import com.sys.dao.imple.MasterDaoImpl;
import com.sys.model.Master;

public class TestMasterDao {
	static MasterDao masterDao = new MasterDaoImpl();
	static Logger logger = Logger.getLogger(TestMasterDao.class.getName());
	public static void main(String[] args) {
		//login();
		delete();
		Update();
		add();
        logger.error("有异常");
        logger.debug("测试代码");
		logger.log(Priority.INFO,"打开信息");
	}
	public static void add() {
		String name="admin3";
		String password="1456";
		int id=4;
		int num=masterDao.add(name, password, id);
		if(num==0) {
			System.out.println("添加失败");
		}else {
			System.out.println("添加成功");
		}
	}
	public static void Update() {
		String name="admin2";
		String password="456";
		int id=3;
		int num=masterDao.Update(name, password, id);
		if(num==0) {
			System.out.println("修改失败");
		}else {
			System.out.println("修改成功");
		}
	}
	public static void delete(){
		int id = 5;
		int num = masterDao.delete(id);
		if(num == 0){
			System.out.println("删除失败！");
		}else{
			System.out.println("删除成功！");
		}
	}
	//登录
	public static void login(){
		//1.用户登录信息
		String username = "admin2";
		String password = "1111";
		
		//2.查询信息
		
		Master master = masterDao.login(username);
		
		//3.判断登录信息
		if(master == null){
			System.out.println("账号不存在！");
		}else{
			if(password.equals(master.getPassword())){
				System.out.println("登录成功！欢迎："+master.getId());
			}else{
				System.out.println("密码错误！");
			}
		}
	}
	

}
