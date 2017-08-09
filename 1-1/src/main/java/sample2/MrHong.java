package sample2;

public class MrHong implements Human {
	private String name;
	private Item item;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public void has() {
		System.out.println(name+" death!");
		item.showName();
	}

}
