package com.sys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sys.pojo.Address;



public class AddressMapperTest {
	private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;
    static {
    	try {
			reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // 增加地址
    @Test
    public void addAddress() {
    	SqlSession session=sqlSessionFactory.openSession();
    	int count=0;
    	String sql="com.sys.mapper.AddressMapper.addAddress";
    	Address address=new Address();
    	address.setId(7);
    	address.setContact("小明");
    	/*bill.setBillCode("BILL2016_019");
    	bill.setProductName("果冻");
    	bill.setProductDesc("饮料");
    	bill.setProductUnit("瓶");
    	bill.setProductCount(3000.00);
    	bill.setTotalPrice(500.00);
    	bill.setIsPayment(2);
    	bill.setCreatedBy(1);
    	bill.setCreationDate("2015-11-24 15:12:03");
    	bill.setModifyBy(1);
    	bill.setModifyDate("2015-11-24 15:12:03");
    	bill.setProviderId(3);*/
    	count=session.insert(sql, address);  
    	if(count==1) {
    		session.commit();
    		System.out.println(count);
    	}		    	
    }
    //通过contact和postCode获得地址
    @Test
    public void getAddressList() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.AddressMapper.getAddressList";
    	Address address=new Address();
    	address.setContact("王丽");    	
    	List<Address> list=null;
    	list=session.selectList(sql,address);
    	for(Address a:list) {
    		System.out.println(a);
    	}
    }
    //通过id删除地址
    @Test
    public void deleteAddress() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.AddressMapper.deleteAddressById";
    	int count=0;
    	count=session.delete(sql,2);    	
		session.commit();
		System.out.println("删除成功"+count);
    	
    }
}
