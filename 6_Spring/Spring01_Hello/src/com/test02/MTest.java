package com.test02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MTest {

	public static void main(String[] args) {
		//resource res = new FileSystemResource("src/com/test02/beans.xml");
		
//		Resource res = enw ClassPathResource("com/test02/beans.xml");
//		BeanFactory factory1 = new XmlBeanFactory(res);
		
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		MessageBean bean = (MessageBean)factory.getBean("korean");
		bean.sayHello("스프링");
		
		//MessageBeanEn 클래스 타입의 빈을 가져다 sayHello 실행
		
		bean = (MessageBean)factory.getBean("english");
		bean.sayHello("gxnho");
		
		
		
		
	}

}
