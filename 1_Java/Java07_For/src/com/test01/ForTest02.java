package com.test01;

import java.util.Scanner;

public class ForTest02 {
	public static void main(String[] args) {
		//testFor1();
		//testFor2();
		//testFor3();
		//testFor4();
		
		//new ForTest02().print2();
		new ForTest02().count();
	}
	
	public static void testFor1() {
		for(int i=0; i<10; i++) {
			
			for(int j=0; j<10; j++) {
				System.out.println("i= " + i + ", j= " + j);
			}
			System.out.println();
			
		}
	}
	
	public static void testFor2() {
		//구구단 2단부터 9단까지 출력
			for(int i=2; i<10; i++) {
				for(int j=1; j<10; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
			System.out.println();
		}
	}
	
	public static void testFor3() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void testFor4() {
		//한 줄에 별표문자를 입력된 줄수와 칸수만큼 출력
		//단, 줄수와 칸수가 일치하는 위치에는 줄 번호에 대한 정수가 출력
		/* 1*****
		 * *2****
		 * **3***
		 * ***4**
		 * ****5*
		 * *****6
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print(" 줄 수 입력: ");
		int row = sc.nextInt();
		System.out.print(" 칸 수 입력: ");
		int col = sc.nextInt();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i==j) {
					System.out.print(i+1);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
	}
	
	public void print2() {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("정수 입력: ");
		int row = sc.nextInt();
		
		if(row>0) {
			for(int i = 0; i<row; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(row<0) {
			for(int i = -row; i>0; i--) {
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else {
			System.out.println("출력 기능이 없습니다.");
		}
			
	

	}
	
	public void count() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		String str = sc.next();
		
		//1. 영문자인지 검사
		for(int i=0; i < str.length(); i++) {
			char temp = str.charAt(i);
			
			if( !((temp>='a' && temp <='z')||(temp>='A' && temp<='Z'))	) {
				System.out.println("영문자가 아닙니다.");
				return; //메소드 종
			}
		}
		//2. 갯수
		System.out.print("문자 입력: ");
		char ch = sc.next().charAt(0);
		
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(ch == str.charAt(i)) {
				count++;
			}
		
		}
		System.out.println("포함된 갯수: " + count + "개");
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}