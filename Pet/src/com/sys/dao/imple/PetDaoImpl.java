package com.sys.dao.imple;

import java.sql.ResultSet;

import com.sys.dao.BaseDao;
import com.sys.dao.PetDao;
import com.sys.model.Pet;

public class PetDaoImpl extends BaseDao implements PetDao {

	@Override
	public int addPet(Pet pet) {
		int num=0;
		String sql="insert into Pet(id,name,health,love) values(?,?,?,?)";
		Object[] params=new Object[4];
		params[0]=pet.getId();
		params[1]=pet.getName();
		params[2]=pet.getHealth();
		params[3]=pet.getLove();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int deletePet(Pet pet) {
		int num=0;
		String sql = "delete from Pet where id = ?";
		Object[] params = new Object[1];
		params[0] = pet.getId();
		num = super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public int updatePet(Pet pet) {
		int num=0;
		String sql="update Pet set name=?,health=?,love=? where id=?";
		Object[] params = new Object[4];
		params[0]=pet.getName();
		params[1]=pet.getHealth();
		params[2]=pet.getLove();
		params[3]=pet.getId();
		num=super.executeUpdate(sql, params);
		return num;
	}

	@Override
	public ResultSet queryPet(Pet pet) {
		ResultSet result=null ;
		String sql="select name=?,health=?,love=? from Pet where id=?";
		Object[] params = new Object[4];
		params[0]=pet.getName();
		params[1]=pet.getHealth();
		params[2]=pet.getLove();
		params[3]=pet.getId();
		result=super.executeQuery(sql, params);
		return result;
	}

}
