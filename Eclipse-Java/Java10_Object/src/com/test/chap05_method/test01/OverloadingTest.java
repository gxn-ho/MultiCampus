package com.test.chap05_method.test01;

//오버로딩 : 한 클래스 내에 동일한 이름의 메소드를 여러 개 작성하는 기법
public class OverloadingTest {
	public int test() {
		return 0;
		//test();
	}
	public int test(int a) {
		return 0;
		//test(3);
	}
	public int test(int a, int b) {
		return 0;
		//test(1, 2);
	}
	//위와 아래는 타입이 다르기 때문에 오버로딩 가능
	public int test(int a, String s) {
		return 0;
	}
	
	/*
	-에러 발생, 매개변수명은 상관없이 자료형의 갯수와 순서가 다르게 작성되어야 한다.
	public int test(int b, int a) {
		return 0;
	}
	*/
	
	public int test(String s, int a) {
		return 0;
	}
	public String test(int a, int b, String str) {
		return null;
	}
	
	/*
	-에러 발생, 리턴 타입이 다르더라도 오버로딩이 적용되지 않는다.
	public int test(int a, int b, String str) {
		return 0;
	}
	*/
	
	/*
	-에러 발생, 접근제한자가 다르더라도 오버로딩이 적용되지 않는다.
	private String test(int a, int b, String str) {
		return null;
	}
	*/
	
	
	
	
	
	
	
	
}
