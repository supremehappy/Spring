package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {

		StopWatch sw = new StopWatch();
		String methodName = arg0.getMethod().getName();
		
		sw.start(methodName);
		
		System.out.println(methodName+" 호출 ");
		
		Object obj = arg0.proceed(); // 조인포인트 호출
		
		sw.stop();
		
		System.out.println("측정시간 : "+sw.getTotalTimeMillis()+"ms");
		
		return obj;
	}

}
