package com.sys.pojo;

import java.io.Serializable;

public class Role implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
   private String roleCode;
   private String roleName;
   private int createdBy;
   private String creationDate;
   private int modifyBy;
   private String modifyDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRoleCode() {
	return roleCode;
}
public void setRoleCode(String roleCode) {
	this.roleCode = roleCode;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public int getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(int createdBy) {
	this.createdBy = createdBy;
}
public String getCreationDate() {
	return creationDate;
}
public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}
public int getModifyBy() {
	return modifyBy;
}
public void setModifyBy(int modifyBy) {
	this.modifyBy = modifyBy;
}
public String getModifyDate() {
	return modifyDate;
}
public void setModifyDate(String modifyDate) {
	this.modifyDate = modifyDate;
}
@Override
public String toString() {
	return "Role [id=" + id + ", roleCode=" + roleCode + ", roleName=" + roleName + ", createdBy=" + createdBy
			+ ", creationDate=" + creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
}
   
}
