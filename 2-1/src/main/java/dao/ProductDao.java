package dao;

import java.util.List;

import model.productList;

public interface ProductDao {

	List<productList> getProList() throws Exception; // 전체 검색
	productList getProduct(Integer pid) throws Exception; // 부분 검색
}
