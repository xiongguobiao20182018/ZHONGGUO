package com.sys.vo;

import com.sys.pojo.Provider;

public class ProviderVo extends Provider{
    private String endCreationDate;

	public String getEndCreationDate() {
		return endCreationDate;
	}

	public void setEndCreationDate(String endCreationDate) {
		this.endCreationDate = endCreationDate;
	}

	@Override
	public String toString() {
		return "ProviderVo [endCreationDate=" + endCreationDate + "]";
	}
    
}
