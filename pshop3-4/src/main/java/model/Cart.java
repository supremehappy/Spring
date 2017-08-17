package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<ProductSet> productList = new ArrayList<ProductSet>();

	public List<ProductSet> getProductList() {
		return this.productList;
	}
	
	public boolean isEmpty(){
		if(this.productList==null || this.productList.isEmpty()){
			return false;
		}
		return false;
	}
	
	public void push(ProductSet pushedProductSet){ // 카트에 상품 담는 메서드
		
		boolean itemExistInCart = false;
		Product pushedProduct = pushedProductSet.getProduct(); // 카트에 담는 상품
		int pushedProductId = pushedProduct.getPid(); // 카트에 담는 상품번호
		
		for(ProductSet cartProductSet : this.productList){ // ItemSet 검사
			
			Product cartProduct = cartProductSet.getProduct(); // 카트에 있는 상품 추출
			int cartProductId = cartProduct.getPid(); // 카트에 있는 상품번호
			
			if(cartProductId == pushedProductId){ // 카트 안 상품번호 == 담으려는 상품번호 
				cartProductSet.addQuantity(cartProductSet.getQuantity()); // 있는 상품이라면 갯수 추가
				itemExistInCart = true;
				break; 
			}
		}
		
		if(!itemExistInCart){ // 카트에 없는 상품
			this.productList.add(pushedProductSet);
		}
	}
	
	public void cleanAll(){ // 카트를 비우는 메서드 
		this.productList = new ArrayList<ProductSet>();
	}
}
