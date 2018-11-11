package com.sys.ui;

import java.util.List;
import java.util.Scanner;

import com.sys.model.Master;
import com.sys.service.impl.MasterServiceImpl;
import com.sys.service.impl.PetServiceImpl;

import service.MasterService;
import service.PetService;

public class PetShop {
	private Scanner scanner = new Scanner(System.in);
	private MasterService masterService = new MasterServiceImpl();
	private PetService petService = new PetServiceImpl();
	public static void main(String[] args) {
		//1.根据菜单输入信息		
		PetShop petShop = new PetShop();
		petShop.init();
	}
	//开始系统
	public void init(){
		showMenu();
		String action = scanner.next();
		switch(action){
		case "1":{
			login();
			break;
		}
		case "2":{
			showAllMaster();
			break;
		}
		case "3":{
			getMasterByInfo();
			break;
		}
		}
	}
	//菜单
	public void showMenu(){
		System.out.println("宠物商店：1、登录   2、查询所有用户  。。。");		
	}
	
	public void login(){
		System.out.println("请输入账号：");
		String name = scanner.next();		
		System.out.println("请输入密码：");
		String password = scanner.next();		
		//2.主人业务层		
		Master master = new Master();
		master.setName(name);
		master.setPassword(password);
		if(!masterService.login(master)){
			System.out.println("重新登录");
		}
	}
	//查询所有用户
	public void showAllMaster(){
		System.out.println("查询所有用户:UI层");
		masterService.getAllMaster();
	}
	public void getMasterByInfo(){
		Master m = new Master();
		m.setName("a");
		/*m.setMoney(100);*/
		List<Master> list = masterService.getMaster(m);
		for(Master ma : list){
			System.out.println(ma.toString());
		}
	}
}
