package com.test01;

public class Operator02 {
	public static void main(String[] args) {
		//++ : 1증가 , ++값	값++
		//-- : 1감소 , --값	값--
		
		//1. 준비
		Operator02	o = new Operator02();
		//2. 실행
		//o.test1();
		o.test2();
	}
	
	public void test1() {
		int age = 19;
		System.out.println("현재 나이는? " + age);
		
		++age;
		System.out.println("++age의 결과는? " + age);
		age++;
		System.out.println("age++의 결과는? " + age);
		
		--age;
		System.out.println("--age의 결과는? " + age);
		
		/*
		2증가		3증가
		+=2;	+=3;
		*/
		
		
	}
	public void test2() {
		int num1 = 20;
		//후위연산자
		//다른 연산 처리 후 증감처리된다.
		int res1 = num1++ *3;
		System.out.println(res1);
		System.out.println(num1);
		
		//전위연산자
		//증감처리 후 다른 연산이 처리된다.
		int num2=20;
		int res2 = ++num2 * 3;
		System.out.println(res2);
		System.out.println(num2);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
