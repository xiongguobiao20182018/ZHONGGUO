package com.sys.dao.imple;

import java.util.ArrayList;
import java.util.List;

import com.sys.dao.AccountDao;
import com.sys.dao.BaseDao;
import com.sys.model.Account;

public class AccountDaoImpl extends BaseDao implements AccountDao {

	@Override
	public int addAccount(Account account) {
		int num = 0;
		try{
			String sql = "INSERT INTO account(pet_id,seller_id,deal_type,buyer_id,price,deal_time)"
					+ "VALUES(?,?,?,?,?,NOW());";
			List<Object> list = new ArrayList<Object>();
			list.add(account.getPet().getId());
			list.add(account.getMaster().getId());
			list.add(account.getDeal_type());
			list.add(account.getPetStore().getId());
			list.add(account.getPrice());
			num = super.executeUpdate(sql, list.toArray());			
		}catch(Exception e){
			System.out.println("交易明细添加失败！！！");
		}finally{
			closeAll();
		}		
		return num;
	}

}
