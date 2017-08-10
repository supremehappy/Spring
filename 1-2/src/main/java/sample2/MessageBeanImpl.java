package sample2;

public class MessageBeanImpl implements MessageBean {
	//어드바이스 추가
	//1. 조인포인트 실행 전 / 2. 조인포인트 실행 후 / 3. 조인포인트 실행 전과 실행 후
	// 3번 
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() { // 조인 포인트 
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("hi, "+name);
	}
	
	
}
