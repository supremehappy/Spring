package sample2;

public class grape implements Item {

	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Override
	public void showName() {
		System.out.println(name+" nano");

	}

}
