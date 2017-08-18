package model;

import java.sql.Timestamp;

public class SaleLine {//매출 상세 정보 & 구매 상세 정보
	private Integer saleId;
	private Integer itemId;
	private Sale sale;
	private Integer saleLineId;
	private Item item;
	private String updateTime;
	private Integer quantity;
	public SaleLine(Sale sale,Integer saleLineId,
			ItemSet itemSet,Timestamp currentTime){
		this.sale=sale; this.saleLineId=saleLineId;
		this.item = itemSet.getItem();
		this.quantity = itemSet.getQuantity();
		this.updateTime = String.valueOf(currentTime);
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Integer getSaleLineId() {
		return saleLineId;
	}
	public void setSaleLineId(Integer saleLineId) {
		this.saleLineId = saleLineId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}







