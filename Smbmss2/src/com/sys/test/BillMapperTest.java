package com.sys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sys.pojo.Bill;


public class BillMapperTest {
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
    //增加订单
    @Test
    public void addBill() {
    	SqlSession session=sqlSessionFactory.openSession();
    	int count=0;
    	String sql="com.sys.mapper.BillMapper.addBill";
    	Bill bill=new Bill();
    	bill.setId(19);
    	bill.setBillCode("BILL2016_019");
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
    	bill.setProviderId(3);
    	count=session.insert(sql, bill);    	
		session.commit();
		System.out.println(count);    	
    }
    //通过查询条件获取供应商列表-模糊查询-getBillList
    @Test
    public void getBillList() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.BillMapper.getBillList";
    	Bill bill=new Bill();
    	bill.setId(1);    	
    	List<Bill> list=null;
    	list=session.selectList(sql,bill);
    	for(Bill b:list) {
    		System.out.println(b);
    	}
    }
    //通过id删除Bill
    @Test
    public void deleteBillById() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.BillMapper.deleteBillById";   	
    	int count=0;
    	count=session.delete(sql, 19);
    	if(count==1) {
    		session.commit();
        	System.out.println("删除数量为："+count);
    	}   	
    }
    //通过billId获取Bill
    @Test
    public void getBillById() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.BillMapper.getBillById";
    	Bill bill=new Bill();
    	bill.setId(1);    	
    	List<Bill> list=null;
    	list=session.selectList(sql,bill);
    	for(Bill b:list) {
    		System.out.println(b);
    	}
    }
    //修改订单信息
    @Test
    public void modifyBill() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.BillMapper.modifyBill";
    	int count=0;
    	Bill bill=new Bill();
    	bill.setModifyBy(1);    	
    	bill.setModifyDate("2012-03-28 13:03:01");
    	bill.setId(18);
    	count=session.update(sql, bill);
    	if(count==1) {
    		session.commit();
    		System.out.println("修改数量为："+count);
    	}
    }
    //根据供应商ID查询订单数量
    @Test
    public void getBillCountByProviderId() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.BillMapper.getBillCountByProviderId";
    	int count=0;    	 	
    	count=session.selectOne(sql, 2);
    	System.out.println("订单数量为："+count);
    }
}
