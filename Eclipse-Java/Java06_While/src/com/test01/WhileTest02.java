package com.test01;

import java.util.Scanner;

public class WhileTest02 {
	
	
	public void testDoWhile() {
		int i=11;
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		System.out.println("종료 후 i 값: "+ i);
	
	
	}
	
	
	public void testDoWhile2() {
		Scanner sc = new Scanner(System.in);
		String str = null;
		
		do {
			System.out.print("문자열 입력: ");
			str =sc.next();
			
		}while(!str.equals("out"));
		//입력한 문자열이 "out이면 반복 종료"
		
	
	
	
	
	
	}
	
	
	
	
	
	
	
}
