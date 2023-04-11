package com.test02;

public class Test01 {
	
	//num1, num2 => 매개변수
	public void sum(int num1, int num2) {
		System.out.println("sum() : " + (num1+num2) );
	}
	
	//반환형, 리턴타입
	public int sum2() {
		return 4;
	}
	
	public int sum3(int no1, int no2) {
		int sum = no1+no2;
		return sum;
	}
}
