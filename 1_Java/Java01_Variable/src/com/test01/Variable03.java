package com.test01;

public class Variable03 {
	public static void main(String args[]) {
		//상수 테스트
		int age; 
		final int AGE;
		
		age = 19;
		AGE = 19;
		
		System.out.println("age: " + age);
		System.out.println("AGE: " + AGE);
		
		age = 20;
		//AGE = 20;
		//에러발생, 상수 변경 불가
		
		//오버플로우
		//byte bnum = 128;
		//에러, 범위 벗어난 값
		
		byte bnum = 127;
		bnum = (byte)(bnum+1);
		
		System.out.println("bnum: " + bnum);
	
	
	
	}
}