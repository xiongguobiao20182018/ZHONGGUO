package com.sys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import com.sys.pojo.User;

public class UserMapperTest {
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
  //1.注册添加用户
    @Test
    public void addUser() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.addUser";
    	int count=0;
    	User user=new User();
    	user.setId(17);
    	user.setUserCode("xiaoming");
    	user.setUserName("小明");
    	user.setUserPassword("111111");
    	user.setGender(1);
    	user.setBirthday("1985-6-5");
    	user.setPhone("13589778888");
    	user.setAddress("成都市武侯区");
    	user.setUserRole(2);
    	user.setCreatedBy(2);
    	user.setCreationDate("2018-5-4 10:05:06");
    	count=session.insert(sql, user);
    	if(count==1) {
    		session.commit();
    		System.out.println("添加成功，用户名为："+user.getUserName());  
    		
    	}else {
    		System.out.println("添加失败");
    	}
    }
  //2.查询用户
    @Test
    public void getUserByWhere() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserByWhere";
    	User user=new User();
    	user.setId(4);
    	//user.setUserCode("liming");
    	List<User> list=null;
    	list=session.selectList(sql,user);
    	for(User _user:list) {
    		System.out.println(_user);
    	}
    }
  //5.通过条件查询-用户表记录数
    @Test
    public void getUserCountByUser() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserCountByUser";
    	int count=0;
    	User user=new User();
    	user.setGender(1);   	
    	count=session.selectOne(sql,user);
    	System.out.println("用户表记录数为："+count);
    }
  //6.通过userId删除user
    @Test
    public void deleteUserById() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.deleteUserById";   	
    	int count=0;
    	count=session.delete(sql, 20);
    	session.commit();
    	System.out.println("删除数量为："+count);
    }
  //7.修改用户信息
    @Test
    public void modifyUser() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.modifyUser";   	
    	int count=0;
    	User user=new User();
    	user.setId(4);
    	user.setUserCode("xiaoming1");
    	user.setUserName("小明1");
    	user.setUserPassword("222211");
    	user.setGender(1);
    	user.setBirthday("1985-6-7");
    	user.setPhone("13589778886");
    	user.setAddress("成都市武侯区1");
    	user.setUserRole(1);
    	user.setCreatedBy(1);
    	user.setCreationDate("2018-5-4 10:05:08");
    	count=session.update(sql, user);
    	session.commit();
    	System.out.println("修改数量为："+count);
    }
  //8.修改当前用户密码
    @Test
    public void updatePwd() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.updatePwd";   	
    	int count=0;
    	User user=new User();    	
    	user.setUserName("李明");
    	user.setUserPassword("123");   	
    	count=session.update(sql, user);
    	session.commit();
    	System.out.println("修改数量为："+count);
    }
  //9.删除批量用户
    @Test
    public void deleteUsersByList() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.deleteUsersByList";  
    	List<Integer> list=new ArrayList<Integer>(); 
    	int count=0;
    	list.add(15);
    	list.add(16);
    	list.add(17);    	
		count=session.delete(sql, list);		
    	if(count==list.size()) {
    		session.commit();
        	System.out.println("批量删除成功，数量为："+count);
    	}
    	
    }
    //一对一映射
    @Test
    public void getUserInfo() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserInfo";   	
    	List<User> list=null;
    	list=session.selectList(sql);
    	for(User u:list) {
    		System.out.println(u);
    	}
    }
  //一对多映射
    @Test
    public void getUserByCollection() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserByCollection";   	
    	List<User> list=null;
    	list=session.selectList(sql,2);
    	for(User u:list) {
    		System.out.println(u);
    	}
    }
    
    //通过userCode获取User
    @Test
    public void getUserByUserCode() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserByUserCode";  	
    	List<User> list=null;
    	list=session.selectList(sql,"xiaoming");
    	for(User _user:list) {
    		System.out.println(_user);
    	}
    }
    //通过条件查询-用户表记录数
    @Test
    public void getUserCount() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserCount";
    	int count=0;
    	User user=new User();
    	user.setUserRole(1);
    	//user.setUserCode("liming");
    	count=session.selectOne(sql, user);
    	session.commit();
    	System.out.println(count);   		   	
    }
    //通过userId获取user
    @Test
    public void getUserById() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getUserById";
    	List<User> list=null;
    	list=session.selectList(sql, 1);
    	//user.setUserCode("liming");
    	for(User _user:list) {
    		System.out.println(_user);
    	}
    	   		   	
    }
    //修改当前用户密码
    @Test
    public void updatePwdByIdAndPwd() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.updatePwdByIdAndPwd";
    	int count=0;
    	User user=new User();
    	user.setId(17);
    	user.setUserPassword("00000");
    	//user.setUserCode("liming");
    	count=session.update(sql, user);
    	if(count==1) {
    		session.commit();
    		System.out.println("修改成功");
    	}   		   	
    }
    //通过条件查询-userList
    @Test
    public void getAllUser() {
    	SqlSession session=sqlSessionFactory.openSession();
    	String sql="com.sys.mapper.UserMapper.getAllUser";
    	User user=new User();
    	user.setUserName("张晨");
    	List<User> list=null;
    	list=session.selectList(sql, user);
    	//user.setUserCode("liming");
    	for(User _user:list) {
    		System.out.println(_user);
    	}    	   		   	
    }
}
