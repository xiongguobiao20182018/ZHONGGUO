package com.sys.dao;

import java.sql.ResultSet;

import com.sys.model.Pet;

public interface PetDao {
	public int addPet(Pet pet);
	public int deletePet(Pet pet);
	public int updatePet(Pet pet);
	public ResultSet queryPet(Pet pet);
}
