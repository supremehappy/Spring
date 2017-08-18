package model;

public class ItemSet {
	private Item item;
	private Integer quantity;
	public ItemSet(Item item, Integer quantity){
		this.item = item; this.quantity = quantity;
	}
	public void addQuantity(Integer add){//갯수 증가 메서드
		int existQuantity = getQuantity();
		setQuantity(existQuantity + add);
	}
	public void  setItem(Item item){//item의 세터 메서드
		this.item = item;
	}
	public Item getItem(){//item의 게터 메서드
		return item;
	}
	public void setQuantity(Integer quantity){//quantity의 세터
		this.quantity = quantity;
	}
	public Integer getQuantity(){//quantity의 게터 메서드
		return quantity;
	}
}




