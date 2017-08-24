package model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Product {
	private Integer pid;
	@NotEmpty(message="상품 이름을 입력하세요.")
	private String name;
	@NotNull(message="상품 가격을 입력하세요.")
	@Range(min=0,message="가격은 {min}이상 입력해야 합니다.")
	private Integer price;
	@NotEmpty(message="상품 설명을 입력하세요.")
	private String content;
	private String p_date;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
}
