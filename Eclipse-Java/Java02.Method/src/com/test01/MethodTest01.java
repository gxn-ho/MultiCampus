package com.test01;

public class MethodTest01 {

	public static void main(String[] args) {
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		defaultMethod();
		privateMethod();
		
	}
	
	//접근제한자 : public protected default private
	
	//어디서 접근(실행) 가능 (+)
	public static void publicMethod() {
		System.out.println("public method");
	}
	//상속시 상속된 곳에서
	//상속이 아닌 경우 같은 패키지 내에서(#)
	protected static void protectedMethod() {
		System.out.println("protected method");
	}
	//같은 패키지 내에서 (default)
	static void defaultMethod() {
		System.out.println("default method");
	}
	//현재 클래스 내에서 (private)
	private static void privateMethod() {
		System.out.println("privaote method");
		
	}
	
	
	
}
