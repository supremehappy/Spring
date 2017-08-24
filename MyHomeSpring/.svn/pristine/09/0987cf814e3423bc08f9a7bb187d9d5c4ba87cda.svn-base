package model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;

@Service
public class Cart {
	@Autowired
	private CartDao cartDao;
	
	private LinkedList<Integer> codeList = 
			new LinkedList<Integer>();
	private LinkedList<Integer> numList = 
			new LinkedList<Integer>();
	public List<CartItem> getCart(String id){
		return cartDao.selectCart(id);
	}
	
	public int getSize(){
		return codeList.size();
	}
	public Integer getCode(int i){
		return codeList.get(i);
	}
	public Integer getNum(int i){
		return numList.get(i);
	}
	public void setCodeList(int index, Integer code){
		this.codeList.add(index, code);
	}
	public void setNumList(int index, Integer num){
		this.numList.add(index,num);
	}
	private void updateCart(Integer code,int num,String id){
		CartItem item = new CartItem();
		item.setCode(code); item.setNum(num);
		item.setId(id);
		this.cartDao.updateCart(item);//DB 수정
	}
	public void addCart(Integer code,int num,String id){
		for(int i=0; i<codeList.size(); i++){
			if(codeList.get(i)== code){//카트에 이미 있는 상품인 경우
				numList.set(i, numList.get(i)+num);
				updateCart(code,numList.get(i),id);
				return;
			}
		}
		//카트에 존재하지 않는 상품이므로, 카트에 담고 DB에 저장
		codeList.add(code); numList.add(num);
		insertCart(code,num,id);
	}
	private void insertCart(Integer code,int num,String id){
		Integer seqno = this.cartDao.selectMaxCart();
		if(seqno == null) seqno = 0;
		CartItem item = new CartItem();
		item.setSeqno(seqno + 1); item.setCode(code);
		item.setNum(num); item.setId(id);
		this.cartDao.insertCart(item);
	}
	public void deleteItem(Integer code,String id){
		System.out.println("codeList.size():"+codeList.size());
		for(int i=0; i<codeList.size(); i++){
			System.out.println("i:"+i);
			if(codeList.get(i)==code){
				codeList.remove(i);
				numList.remove(i);
				CartItem cartItem = new CartItem();
				cartItem.setCode(code); cartItem.setId(id);
				cartDao.deleteCart(cartItem);
				System.out.println("삭제상품code:"+code);
				return;
			}
		}
	}
	public void modifyItem(Integer code,int num,String id){
		for(int i=0; i<codeList.size(); i++){
			if(codeList.get(i)==code){
				numList.set(i, num);
				updateCart(code,num,id);
				return;
			}
		}
	}
}









