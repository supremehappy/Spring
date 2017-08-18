package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<ItemSet> itemList=new ArrayList<ItemSet>();
	public List<ItemSet> getItemList(){//게터		
		return this.itemList;
	}
	public boolean isEmpty(){//카트가 비어있는지 체크
		if(this.itemList == null || this.itemList.isEmpty()){
			return true;
		}
		return false;
	}
	public void clealAll(){//카트를 비우는 메서드
		this.itemList = new ArrayList<ItemSet>();
	}
	public void push(ItemSet pushedItemSet){//카트에 담는 메서드
		boolean itemExistInCart = false;
		Item pushedItem = pushedItemSet.getItem();//카트에 담을 상품
		int pushedItemId = pushedItem.getItemId();//카트에 담을 상품번호
		for(ItemSet cartItemSet : this.itemList){
		//현 카트에 담긴 모든 ItemSet을 검사한다.
			Item cartItem = cartItemSet.getItem();//카트에 있는 상품
			int cartItemId = cartItem.getItemId();//카트에 있는 상품번호
			if(cartItemId == pushedItemId){
			//카트에 있는 상품의 번호와 카트에 담으려는 상품의 번호가 같은 경우
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				//카트에 있는 상품의 갯수에 추가하는 상품의 갯수를 더한다.
				itemExistInCart = true;//이미 카트에 있는 상품이라고 설정한다.
				break;//갯수가 추가되었으므로 반복을 중단
			}
		}
		if( ! itemExistInCart){//이미 카트에 있는 상품이 아닌 경우
			this.itemList.add(pushedItemSet);//상품을 카트에 추가
		}
	}
}








