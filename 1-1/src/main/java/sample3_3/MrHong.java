package sample3_3;

import org.springframework.beans.factory.annotation.Autowired;

public class MrHong implements Human {
	private String name;
	private Item item;
	
	public MrHong(String name){
		this.name=name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public void has() {
		System.out.println(name+" death!");
		item.showName();
	}

}
