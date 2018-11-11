package com.sys.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;



public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	static {
		//记载属性集文件
		Properties p = new Properties();
		try {
			InputStream input=BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
			p.load(input);
		} catch (IOException e) {
			
			e.printStackTrace();
		}//读取信息
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
		System.out.println(driver+"|"+url+"|"+user+"|"+password);
		try {			
			Class.forName(driver);
		} catch (ClassNotFoundException e) {//ClassNotFoundException 找不到类
			System.out.println("驱动加载失败！");
			e.printStackTrace();
		}
		
	}
    public BaseDao() {
    	
    }
    //返回连接
    public Connection getConnection() {
    	Connection conn=null;
    	try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }
    //修改
    public int executeUpdate(String sql,Object[] params) {
    	int num=-1;
    	try {
    		//创建数据库连接
        	conn=getConnection();
        	pstmt=conn.prepareStatement(sql);
        	if(params!=null) {
        		for(int i=0;i<params.length;i++) {
        			pstmt.setObject(i+1,params[i]);
        		}
        	}
        	//执行SQL
        	num=pstmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		closeAll();
    	}
    	
    	return num;
    }
    //查询
    public ResultSet executeQuery(String sql,Object[] params) {
    	try {
    		//创建连接
    		conn=getConnection();
    		pstmt=conn.prepareStatement(sql);
    		//传递参数
    		if(params!=null) {
    			for(int i=0;i<params.length;i++) {
    				pstmt.setObject(i+1,params[i]);
    			}
    		}
    		//执行SQL
    		rs=pstmt.executeQuery();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		closeAll();
    	}
    	return rs;
    }
    
  //关闭连接
  	public void closeAll(){
  		try{
  			if(rs != null){
  				rs.close();
  			}
  			if(pstmt != null){
  				pstmt.close();
  			}
  			if(conn != null){
  				conn.close();
  			}
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  	}
}
