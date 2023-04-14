package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//applicationContext.xml에 MyClass bean 설정 후
		//생성된 MyClass 타입의 빈을 main에서 prn() 실행하여 결과 확인
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MyClass myClass = (MyClass) factory.getBean("myClass");
		myClass.prn();
		
		
	}

}
