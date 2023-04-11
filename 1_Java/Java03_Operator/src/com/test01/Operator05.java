package com.test01;

public class Operator05 {
	public static void main(String[] args) {
		
		new Operator05().test01();
		new Operator05().test02();
	}
	public void test01() {
		//삼항연산자: 항목이 3개=> (조건식)?참일때:거짓일때;
		
		int num = 0;
		//양수인지 양수가 아닌지 확인
		//String res = (num>0)?"양수다":"양수가 아니다";
		
		//중첩하여 사용
		String res = (num>0) ? "양수다" : (num==0) ? "0이다"  : "음수다";
		
		
		System.out.println(res);
		
	}
	
	public void test02( ) {
		//복합대입연산자
		int num=12;
		
		System.out.println(num);
		
		num = num + 3;
		System.out.println(num);
		
		num += 3;
		System.out.println(num);
		
		num -= 5;
		System.out.println(num);
		
		num *= 2;
		System.out.println(num);
		
		num /= 2;
		System.out.println(num);
		
		num %= 5;
		System.out.println(num);
		
	}
	
	
	
	
	
	
	
	
	
	
}
