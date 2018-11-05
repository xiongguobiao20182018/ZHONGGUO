package com.sys.mapper;

import java.util.List;



public interface Role {
	//获得所有角色
	public List<Role> getRoleList()throws Exception;
	//增加角色
	public int addRole(Role role)throws Exception;
    //通过id删除角色
	public int deleteRoleById(int id)throws Exception; 
	//通过id 获取角色
	public Role getRoleById(int id)throws Exception;
	//修改角色
	public int updateRoleById(Role role)throws Exception;
}
