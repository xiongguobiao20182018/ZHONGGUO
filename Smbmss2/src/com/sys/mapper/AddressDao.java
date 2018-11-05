package com.sys.mapper;

import java.util.List;

import com.sys.pojo.Address;


public interface AddressDao {
    //增加地址
	public int addAddress(Address address)throws Exception;
	//通过contact和postCode获得地址
	public List<Address> getAddressList(String contact,String postCode)throws Exception;
	//通过id删除地址
	public int deleteAddressById(int id)throws Exception; 
	//通过id 获取Address
	public Address getAddressById(int id)throws Exception;
	//修改地址
	public int updateAddressById(Address address)throws Exception;
}
