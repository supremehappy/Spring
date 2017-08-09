package sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellowApplication {

	public static void main(String[] args) {
		
//		MessageBean mb = new MessageBeanKr();
//		mb.sayHello("ㅇㅅㅇ");
//		
//		mb = new MessageBeanEn();
//		mb.sayHello("what");
		
		//환경설정
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample1/beans.xml");
		
		MessageBean bean = (MessageBean)ctx.getBean("messageKr",MessageBean.class);
		bean.sayHello("ㅇㅅㅇ");
		
		bean = (MessageBean)ctx.getBean("messageEn",MessageBean.class);
		bean.sayHello("what");
		
	}
	
}
