package com.sys.dao.imple;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.MasterDao;
import com.sys.model.Master;

public class MasterDaoImpl extends BaseDao implements MasterDao {

	@Override
	public Master login(String name) {
		Master master = null;
		try{
			String sql = "select * from master where name = ?";
			Object[] params = new Object[1];
			params[0] = name;
			ResultSet rs = super.executeQuery(sql, params);
			while(rs.next()){
				master = new Master();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return master;
	}

	@Override
	public int delete(int id) {
		int num = 0;
		try{
			String sql = "delete from master where id = ?";
			Object[] params = new Object[1];
			params[0] = id;
			num = super.executeUpdate(sql, params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int Update(String name, String password, int id) {
		int num=0;
		try {
			String sql="update master set name=?,password=? where id=?";
			Object[] params = new Object[3];
			params[0]=name;
			params[1]=password;
			params[2]=id;
			num=super.executeUpdate(sql, params);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int add(String name, String password, int id) {
		int num=0;
		try {
			String sql="insert into master(name,password,id) values(?,?,?)";
			Object[] params = new Object[3];
			params[0]=name;
			params[1]=password;
			params[2]=id;
			num=super.executeUpdate(sql, params);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Master> getAllMaster() {
		System.out.println("Dao层");		
		//封装实体类Master
		List<Master> list = new ArrayList<Master>();
		try {
			String sql = "select * from master";
			ResultSet rs = super.executeQuery(sql, null);			
			while(rs.next()){
				Master master = new Master();
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				master.setPassword(rs.getString("password"));
				master.setMoney(rs.getInt("money"));
				list.add(master);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			closeAll();
		}		
		return list;
	}

	@Override
	public List<Master> getMasterByInfo(Master master) {
		
		
		//封装实体类Master
		List<Master> list = new ArrayList<Master>();
		try {
			String sql = "select * from master where 1=1 ";
			List<Object> paramsList = new ArrayList<Object>();
			if(master != null){
				if(master.getName() != null){
					sql += " and NAME LIKE ? ";
					paramsList.add("%"+master.getName()+"%");
				}
				if(master.getMoney() != 0){
					sql += " and money LIKE ? ";
					paramsList.add("%"+master.getMoney()+"%");
				}
			}
			/*System.out.println(sql);			
			System.out.println(paramsList.toArray().length);
			System.out.println(paramsList.toArray()[0]);*/
			ResultSet rs = super.executeQuery(sql, paramsList.toArray());			
			while(rs.next()){
				Master m = new Master();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPassword(rs.getString("password"));
				m.setMoney(rs.getInt("money"));
				list.add(m);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			closeAll();
		}		
		return list;
	}

	@Override
	public int updateMoney(int money, int id) {
		int num = 0;
		try{
			String sql = "UPDATE MASTER SET money = ? WHERE id = ?; ";
			List<Object> list = new ArrayList<Object>();
			list.add(money);
			list.add(id);
			num = super.executeUpdate(sql, list.toArray());			
		}catch(Exception e){
			System.out.println("主人修改金额失败！！");
		}finally{
			closeAll();
		}		
		return num;
	}

	

}
