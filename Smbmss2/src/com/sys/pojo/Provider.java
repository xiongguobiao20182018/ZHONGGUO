package com.sys.pojo;

import java.io.Serializable;

public class Provider implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//主键ID
    private String proCode;//供应商编码
    private String proName;//供应商名称
    private String proDesc;//供应商详细描述
    private String proContact;//供应商联系人
    private String proPhone;//联系电话
    private String proAddress;//地址
    private String proFax;//传真
    private long createdBy;//创建者（userId）
    private String creationDate;//创建时间
    private String modifyDate;//更新时间
    private long modifyBy;//更新者（userId）
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}
	@Override
	public String toString() {
		return "Provider [id=" + id + ", proCode=" + proCode + ", proName=" + proName + ", proDesc=" + proDesc
				+ ", proContact=" + proContact + ", proPhone=" + proPhone + ", proAddress=" + proAddress + ", proFax="
				+ proFax + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyDate=" + modifyDate
				+ ", modifyBy=" + modifyBy + "]";
	}
    
}
