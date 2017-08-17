package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<ItemSet> itemList = new ArrayList<ItemSet>();

	public List<ItemSet> getItemList() {
		return this.itemList;
	}
	
	public boolean isEmpty(){
		if(this.itemList==null || this.itemList.isEmpty()){
			return false;
		}
		return false;
	}
	
	public void push(ItemSet pushedItemSet){ // 카트에 상품 담는 메서드
		
		boolean itemExistInCart = false;
		Item pushedItem = pushedItemSet.getItem(); // 카트에 담는 상품
		int pushedItemId = pushedItem.getItemId(); // 카트에 담는 상품번호
		
		for(ItemSet cartItemSet : this.itemList){ // ItemSet 검사
			
			Item cartItem = cartItemSet.getItem(); // 카트에 있는 상품 추출
			int cartItemId = cartItem.getItemId(); // 카트에 있는 상품번호
			
			if(cartItemId == pushedItemId){ // 카트 안 상품번호 == 담으려는 상품번호 
				cartItemSet.addQuantity(pushedItemSet.getQuantity()); // 있는 상품이라면 갯수 추가
				itemExistInCart = true;
				break; 
			}
		}
		
		if(!itemExistInCart){ // 카트에 없는 상품
			this.itemList.add(pushedItemSet);
		}
	}
	
	public void cleanAll(){ // 카트를 비우는 메서드 
		this.itemList = new ArrayList<ItemSet>();
	}
}
