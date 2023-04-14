package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test03/applicationcontext.xml");
		School person = factory.getBean("mySchool",School.class);
		System.out.println(person);
		
	}

}
