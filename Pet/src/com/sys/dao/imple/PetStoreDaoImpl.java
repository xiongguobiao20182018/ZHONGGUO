package com.sys.dao.imple;

import java.util.ArrayList;
import java.util.List;

import com.sys.dao.BaseDao;
import com.sys.dao.PetStoreDao;

public class PetStoreDaoImpl extends BaseDao implements PetStoreDao {

	@Override
	public int updateMoney(int balance, int id) {
		int num = 0;
		try{
			String sql = "UPDATE petStore SET balance = ? WHERE id = ?;";
			List<Object> list = new ArrayList<Object>();
			list.add(balance);
			list.add(id);
			num = super.executeUpdate(sql, list.toArray());			
		}catch(Exception e){
			System.out.println("宠物商店修改金额失败！！");
		}finally{
			closeAll();
		}		
		return num;
	}

}
