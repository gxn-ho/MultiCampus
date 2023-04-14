package com.test06;

public class BeanFactory {
	Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
			
		}else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}
}
