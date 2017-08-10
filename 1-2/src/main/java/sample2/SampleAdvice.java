package sample2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class SampleAdvice { // 일반 클래스 = pojo
	
	// 일반클래스를 어드바이스로 이용

	@Around("execution(* sayHello())") // 조인 포인트 앞뒤로 실행 / @Before 조인포인트 앞에 실행 / @After 조인포인트 뒤에 실행
	//execution(1 2 3) : 1 접근제어자(ex: public) 생략가능 / 2 메서드 리턴 타입 / 3 패키지 이름, 클래스이름, 메서드 이름(매개변수 타입)
	//ex) execution(* name()) : 이름이 name, 매개변수 없는 메서드
	//ex) execution(* name(..)) : 이름이 name, 매개변수가 있거나 없는 메서드('..' 은 0개 이상)
	//ex) execution(* public void name*()) : public, void 메서드, name, 매개변수가 없는 메서드
	//ex) execution(* public * * sample.*.*(..)) : public, 모든 리턴타입, sample 패키지 밑에 속하며, 매개변수가 있거나 없는 메서드
	//ex) execution(* sample..*.*(..)) : 모든 리턴타입, sample 및 그 하위 패키지에 속하는 모든 메서드에 매개변수가 있거나 없는 메서드
	public Object sample(ProceedingJoinPoint pjp) throws Throwable{
		String methodName =pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		
		sw.start(methodName);
		
		System.out.println(methodName+" 호출");
		
		Object obj = pjp.proceed();
		
		sw.stop();
		
		System.out.println("소요시간 : "+sw.getTotalTimeMillis()+" s");
		
		return obj;
	}
}
