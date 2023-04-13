package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address bae = (Address)factory.getBean("bae");
		Address jeon = (Address)factory.getBean("jeon");
		
		System.out.println(bae);
		System.out.println(jeon);
		
	}

}
