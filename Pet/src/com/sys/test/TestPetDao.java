package com.sys.test;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.sys.dao.PetDao;
import com.sys.dao.imple.PetDaoImpl;
import com.sys.model.Pet;

public class TestPetDao {
	static PetDao petDao = new PetDaoImpl();
	public static void main(String[] args) {
		Logger loger = Logger.getLogger(TestPetDao.class.getName());
		loger.error("添加失败！");
		add();
		delete();
        update();
        query();
	}
	public static void add() {
		int id=2;
		String name="白白";
		int health=100;
		int love =80;
		Pet pet=new Pet();
		pet.setId(id);
		pet.setName(name);
		pet.setHealth(health);
		pet.setLove(love);
		int num=petDao.addPet(pet);
		if(num==0) {
			System.out.println("添加失败");
		}else {
			System.out.println("添加成功");
		}
	}
	public static void delete() {
		int id=3;
		Pet pet=new Pet();
		pet.setId(id);
		int num=petDao.deletePet(pet);
		if(num==0) {
			System.out.println("删除失败");
		}else {
			System.out.println("删除成功");
		}
	}
	public static void update() {
		String name="白白";
		int health=100;
		int love =80;
		int id=2;
		Pet pet=new Pet();
		pet.setId(id);
		pet.setName(name);
		pet.setHealth(health);
		pet.setLove(love);
		int num=petDao.updatePet(pet);
		if(num==0) {
			System.out.println("修改失败");
		}else {
			System.out.println("修改成功");
		}
	}
	public static void query() {
		String name="白白";
		int health=100;
		int love =80;
		int id=2;
		Pet pet=new Pet();
		pet.setId(id);
		pet.setName(name);
		pet.setHealth(health);
		pet.setLove(love);
		ResultSet result=petDao.queryPet(pet);
		if(result==null) {
			System.out.println("查询失败");
		}else {
			System.out.println("查询成功");
		}
	}
}
