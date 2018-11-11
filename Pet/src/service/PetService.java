package service;

import java.util.List;

import com.sys.model.Pet;

public interface PetService {
	//查询所有宠物
     public List<Pet> getAllPet();
		
	//修改宠物信息
	public boolean update(Pet pet);
}
