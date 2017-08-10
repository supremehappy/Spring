package sample3_3;

public class Apple implements Item {
	
	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public void showName() {
		System.out.println(name+" yo!");

	}

}
