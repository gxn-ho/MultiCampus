package com.test.chap05_method.test02;

public class Run {
	public static void main(String[] args) {
		NonStaticMethodTest test = new NonStaticMethodTest();
		
		
		//1. 매개변수와 반환값이 없는 메소드 호출
		test.method1();
		
		//2. 매개변수가 있고, 반환값이 없는 메소드 호출
		test.method2(10, 20);
		
		//3. 매개변수가 없고, 반환값이 있는 메소드 호출
		String result = test.method3();
		System.out.println(result);
		
		//4. 매개변수가 있고, 반환값도 있는 메소드 호출
		int result1 = test.method4(20, 30);
		System.out.println("result: " + result1);
		System.out.println("result: " + test.method4(40, 45));
		
		//클래스명.메소드명()
		StaticMethodTest.staticMethod1();
		
		String res = StaticMethodTest.staticMethod2("정건호");
		System.out.println(res);
		
	}

}
