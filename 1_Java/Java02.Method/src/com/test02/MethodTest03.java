package com.test02;

import com.test01.MethodTest01;
		//패키지명은 소문자, 클래스명은 대문자

//MethodTest01과 다른 클래스&다른 패키지
public class MethodTest03 /*extends MethodTest01*/ {
	public static void main(String[] args) {
		MethodTest01.publicMethod();
		//MethodTest01.protectedMethod();
		//MethodTest01.defaultMethod();
		
		//매개변수 있는 메소드 실행
		//1.준비
		Test01 t = new Test01();
		//2.실행
		t.sum(2,5);
		int no = t.sum2();
		System.out.println(no);
		
		int sum = t.sum3(11,22);
		System.out.println(sum);
		
	// 준비
		// 클래스명   변수명 = new 클래스명();
	// 실행
		// 변수명, 매소드명();
		
		
		
		
	}

}
