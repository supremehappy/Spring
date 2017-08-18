package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Item {

	// @Email : 유효한 이메일인지 검증 | @Length : 지정한 범위의 길이인지 검증 | 
	// 
	private Integer itemId;
	@NotEmpty // null 혹은 빈문자가 아닌지 검증 (Hibernate 에서 제공하는 어노테이션)
	private String itemName;
	@NotNull // null이 아닌지 검증 | Null : null 인지 검증
	@Min(0) // 지정한 값보다 큰지 검증 | Max : 지정한 값보다 작은지 검증
	private Integer price;
	@NotEmpty
	private String description;
	private String pictureUrl;
	private MultipartFile picture;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
	
	
}
