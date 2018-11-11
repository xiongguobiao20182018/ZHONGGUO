package service;

import java.util.List;

import com.sys.model.Account;
import com.sys.model.Master;
import com.sys.model.Pet;

public interface MasterService {
	public boolean login(Master master);
	//查询所有用户
	public List<Master> getAllMaster();
    public List<Master> getMaster(Master master);
	
	//查询某个用户的所有宠物信息
	public List<Pet> getPetsByMasterId(int id);
	
	//事务控制：主人售卖宠物    
	public boolean sallPet(Account account);
}
