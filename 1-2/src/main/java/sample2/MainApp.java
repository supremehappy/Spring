package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		MessageBean bean = (MessageBean) ctx.getBean("targetBean");
		
		bean.sayHello();
		
		
	}

}
