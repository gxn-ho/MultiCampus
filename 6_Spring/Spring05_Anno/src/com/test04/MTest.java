package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		MyNickNamePrn myNick = factory.getBean("my", MyNickNamePrn.class);
		System.out.println(myNick);
	}

}
