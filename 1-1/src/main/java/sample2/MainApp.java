package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	
	public static void main(String[] args) {
		
//		MrHong h = new MrHong();
//		
//		h.setName("wow");
//		
//		Apple a = new Apple();
//		
//		a.setName("apple");
//		
//		h.setItem(a);
//		h.has();
//		
//		Banana b = new Banana();
//		
//		b.setName("banana");
//		h.setItem(b);
//		h.has();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sample2/beans.xml");
		
		MrHong h = (MrHong)ctx.getBean("mr");
		h.has();
		
		h = (MrHong)ctx.getBean("lee");
		h.has();
	}
}
