package com.sys.model;

public class Pet {
	private int id;
	private String name;
	private String type_name;
	private int health;
	private int love;
	private String birthday;
	private Master master;
	private PetStore petStore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public PetStore getPetStore() {
		return petStore;
	}
	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	}
	
    
}
