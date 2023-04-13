package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean fruit = (MessageBean)factory.getBean("fruit");
		fruit.sayHello();
		
		MessageBean apple = (MessageBean)factory.getBean("apple");
		apple.sayHello();
		
		MessageBean mango = (MessageBean)factory.getBean("mango");
		mango.sayHello();
		
		
	}

}
