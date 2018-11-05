package com.sys.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.sys.pojo.Provider;


public class ProviderMapperTest {
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
  //查询所有供应商ss
  	@Test
      public void m01() {
  		SqlSession session=sqlSessionFactory.openSession();
  		String sql="com.sys.mapper.ProviderMapper.getALLProviders";
  		List<Provider> list=null;
  		list=session.selectList(sql);
  		for(Provider p:list) {
  			System.out.println(p);
  		}
  	}
  //模糊查询所有供应商
  	@Test
      public void m02() {
  		SqlSession session=sqlSessionFactory.openSession();
  		String sql="com.sys.mapper.ProviderMapper.getProviderByName";
  		List<Provider> list=null;
  		list=session.selectList(sql,"厂");
  		for(Provider p:list) {
  			System.out.println(p);
  		}
  	}
  //多条件查询所有供应商
  	@Test
      public void m03() {
  		SqlSession session=sqlSessionFactory.openSession();
  		String sql="com.sys.mapper.ProviderMapper.getProviderByNameAndRole";
  		Provider pro=new Provider();
  		pro.setProName("北京");
  		pro.setProCode("BJ_GYS001");
  		List<Provider> list=null;
  		list=session.selectList(sql,pro);
  		for(Provider p:list) {
  			System.out.println(p);
  		}
  	}
  	//resultMap查询所有供应商
  	@Test
      public void m04() {
  		SqlSession session=sqlSessionFactory.openSession();
  		String sql="com.sys.mapper.ProviderMapper.getProviderByMap";
  		List<Provider> list=null;
  		list=session.selectList(sql);
  		for(Provider p:list) {
  			System.out.println(p);
  		}
  	}
  	
  	@Test
  	//增加供应商
  	public void add() {
  		SqlSession sqlSession=null;	
  		String sql="com.sys.mapper.ProviderMapper.add";
  		int count=0;
  		sqlSession=sqlSessionFactory.openSession();
  		//sqlSession=MyBatisUtil.createSqlSession();
  		Provider provider=new Provider();
  		provider.setId(18);
  		provider.setProCode("BJ_GYS002");
  		provider.setProName("有限公司");
  		provider.setProDesc("长期伙伴");
  		provider.setProContact("张三");
  		provider.setProPhone("13566897784");
  		provider.setProAddress("地方");
  		provider.setProFax("123");
  		provider.setCreatedBy(1);
  		count=sqlSession.insert(sql, provider);
  		sqlSession.commit();
  		System.out.println(count);
  		
  		
  	}
  	/*@Test
  	//修改供应商
  	public void modify() {
  		SqlSession sqlSession=null;		
  		int count=0;
  		sqlSession=MyBatisUtil.createSqlSession();
  		Provider provider=new Provider();
  		provider.setId(16);
  		provider.setProCode("BJ_GYS005");
  		provider.setProName("有限公司2");
  		provider.setProDesc("短期伙伴");
  		provider.setProContact("张三1");
  		provider.setProPhone("13566897786");
  		provider.setProAddress("地方1");
  		provider.setProFax("123456");
  		provider.setCreatedBy(2);
  		count=sqlSession.getMapper(ProviderMapper.class).modify(provider);
  		sqlSession.commit();
  		System.out.println(count);			
  	}*/
  	@Test
  	//删除供应商
  	public void del() {
  		SqlSession sqlSession=sqlSessionFactory.openSession();	
  		String sql="com.sys.mapper.ProviderMapper.del";
  		int count=0;		
  		int id=16;
  		count=sqlSession.delete(sql, id);
  		sqlSession.commit();
  		System.out.println(count);
  	}
  	@Test
  	//修改供应商
  	public void updateProviderById() {
  		SqlSession sqlSession=sqlSessionFactory.openSession();	
  		String sql="com.sys.mapper.ProviderMapper.updateProviderById";
  		int count=0;		
  		Provider provider=new Provider();
  		provider.setId(2);		
  		provider.setProPhone("13566897786");		
  		//provider.setCreatedBy(1);
  		count=sqlSession.update(sql, provider);
  		if(count==1) {
  			sqlSession.commit();
  			System.out.println(count);
  		}							
  	}
  	//7.批量删除  FOREACH
  		@Test
  		public void m08(){
  			//3.开启SqlSession
  			SqlSession session = sqlSessionFactory.openSession();
  			//4.找到sql namespace+id
  			String sql = "com.sys.mapper.ProviderMapper.delProviders";
  			//5.执行sql，完成映射
  			//封装List
  			List<Integer> list = new ArrayList<Integer>();
  			list.add(1);
  			list.add(2);
  			list.add(3);
  			list.add(1);
  			/*List<Provider> list2 = new ArrayList<Provider>();
  			Provider p1 = new Provider();
  			p1.setId(4);
  			list2.add(p1);*/
  			System.out.println(session.delete(sql, list));
  			session.close();
  		}
  		//9.时间查询 CHOOSE
  		/*@Test
  		public void m09(){
  			//3.开启SqlSession
  			SqlSession session = sqlSessionFactory.openSession();
  			//4.找到sql namespace+id
  			String sql = "com.sys.mapper.ProviderMapper.getProviderByChoose";
  			//5.执行sql，完成映射
  			//封装ProviderVo
  			ProviderVo pv = new ProviderVo();
  			pv.setCreationDate("2014-01-01");
  			//pv.setCreationDate("2014-01-01");
  			pv.setEndCreationDate("2015-01-28 10:10:10");
  			List<Provider> list = session.selectList(sql, pv);
  			for(Provider p : list){
  				System.out.println(p);
  			}
  			session.close();
  		}*/
  		//通过proId获取Provider
  		@Test
        public void getProviderById() {
    		SqlSession session=sqlSessionFactory.openSession();
    		String sql="com.sys.mapper.ProviderMapper.getProviderById";
    		List<Provider> list=null;
    		list=session.selectList(sql,1);
    		for(Provider p:list) {
    			System.out.println(p);
    		}
    	}
}
