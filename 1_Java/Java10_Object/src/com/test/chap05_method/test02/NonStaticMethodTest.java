package com.test.chap05_method.test02;

public class NonStaticMethodTest {
	//매개변수 유무와 반환값 유무에 따른 메소드 표현
	//1. 매개변수 없고, 반환값 없는 메소드
	public void method1() {
		System.out.println("매개변수와 반환값이 둘 다 없는 메소드.");
		
		//return; : 생략
	}
	//2. 매개변수 있고, 반환값이 없는 메소드
	public void method2(int num1, int num2) {
		//호출하는 쪽의 괄호에 인자값으로 넘긴 값을 받기위해 선언하는 것이 매개변수.
		int sum = num1+num2;
		System.out.println(sum);
		return;
	}
	//3. 매개변수 없고, 반환값이 있는 메소드
	public String method3() {
		return "매개변수 없고, 반환값이 있는 메소드.";
	}
	//4. 매개변수 있고, 반환값이 있는 메소드
	public int method4(int num1, int num2) {
		int sum = num1+num2;
		return sum;
	}
	
	
	
	
	
	
}
