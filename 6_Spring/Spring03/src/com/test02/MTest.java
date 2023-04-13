package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Emp cha = factory.getBean("cha", Emp.class);
		Emp son = factory.getBean("son", Emp.class);
		
		System.out.println(cha);
		System.out.println(son);
	}

}
