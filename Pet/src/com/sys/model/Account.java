package com.sys.model;

public class Account {
	private int id;
	private Pet pet;
	private Master master;
	private int deal_type; // 1 代表 购买   2代表 售卖  3 商店  4.人
	private PetStore petStore;
	private int price;
	private String deal_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public int getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(int deal_type) {
		this.deal_type = deal_type;
	}
	public PetStore getPetStore() {
		return petStore;
	}
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeal_time() {
		return deal_time;
	}
	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
	} 
	
}
