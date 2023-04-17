package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜서 sts를 실행한다.");
	}
}
