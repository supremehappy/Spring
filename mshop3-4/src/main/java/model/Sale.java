package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private Integer saleId;
	private String updateTime;
	private String userId;
	private  User user;
	private List<SaleLine> saleLineList = new ArrayList<SaleLine>();
	
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<SaleLine> getSaleLineList() {
		return saleLineList;
	}
	public void setSaleLineList(List<SaleLine> saleLineList) {
		this.saleLineList = saleLineList;
	}
	
	//---------------------------------------------------------
	
	public void addSaleLine(SaleLine saleLine){
		this.saleLineList.add(saleLine);
	}
	
	
}
