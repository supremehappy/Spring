package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import dao.InsertProductDao;
import dao.ProductDao;
import model.Player;
import model.Team;
import model.productList;

public class InsertProductUi  extends AbstractUi {

	private ProductDao productDao;
	private InsertProductDao insertProductDao;
		
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void setInsertProductDao(InsertProductDao insertProductDao) {
		this.insertProductDao = insertProductDao;
	}

	protected void showProductField(productList list){
		final String productId = "상품ID";
		
		showMenu(productId);
		
		String id = getInputedString();
		
		if(StringUtils.isEmpty(id)){
			return;
		}else if(NumberUtils.isNumber(id)){
			try{
				productList pro = this.productDao.getProduct(Integer.parseInt(id));
				
				if(pro==null){
					System.out.printf("입력된 번호 %d 인 상품은 존재하지 않습니다.",id);
					showProductField(pro);
				}else{
					list.setName(pro.getName());
					showProductId(pro);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	protected void showProductId(productList list){
		
		if(list == null){
			System.out.println("null");
		}else{
			System.out.println("hi");
		}
		
		final String productId = "상품ID 2";
		
		showMenu(productId);
		
		String id = getInputedString();
		
		if(StringUtils.isEmpty(id)){
			return;
		}else if(NumberUtils.isNumber(id)){
			list.setPid(Integer.parseInt(id));
			
			try{
				this.insertProductDao.insertProduct(list);
				System.out.printf("상품게시판에 %s 상품을 등록했습니다.%n",list.getName());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	protected void showMenu(String str){
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.printf("%s 을/를 입력하고 엔터",str);
		System.out.println("아무것도 입력하지 않고 엔터 누르면 메뉴로 돌아감");
	}
	@Override
	public void show() throws Exception {
		final String productName ="상품명";
		
		showMenu(productName);
		
		String name = getInputedString();
		
		if(StringUtils.isEmpty(name)){
			return;
		}else if(name.length() < 128 && name.length() > 0){
			productList list = new productList();
			
			list.setName(name);
			
			showProductField(list);
		}else {//이름 길이가 0 보다 적거나 128 보다 큰 경우
			show();
		}
	}

}
