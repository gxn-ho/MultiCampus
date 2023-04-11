package com.test01;

public class Operator01 {
	public static void main(String[] args) {
		// !논리값 : 논리값을 반대로 바꾸는 연산자
		
		System.out.println("true의 부정: " + !true);
		System.out.println("false의 부정: " + !false);
		
		//키보드로 정수 하나 입력받아 짝수 홀수 확인
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("정수 하나 입력: ");
		int num = sc.nextInt();
		
		System.out.println("입력한 정수가 짝수인가? " + (num%2==0) );
		System.out.println("입력한 정수가 짝수인가? " + !(num%2!=0) );
		
		
		
		
		
		
		
	}
}
