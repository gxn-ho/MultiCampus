package com.test01;

public class Woman {
	public void classWork() {
		System.out.println("qr코드를 찍는다.");
		
		try {
			System.out.println("컴퓨터를 켜서 sts를 실행한다.");
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에 간다.");
		}
	}
}
