package model;

public class ProductSet {

	private Product product;
	private Integer quantity;
	
	public ProductSet(Product product, Integer quantity){
		this.product=product;
		this.quantity=quantity;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product product){
		this.product=product;
	}
	
	public Integer getQuantity(){
		return quantity;
	}
	
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}

	public void addQuantity(Integer add){ // 갯수 증가 매서드 
		int existQuantity = getQuantity();
		setQuantity(existQuantity + add);
	}
}
