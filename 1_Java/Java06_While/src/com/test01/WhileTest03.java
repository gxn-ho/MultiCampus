package com.test01;

public class WhileTest03 {
	public static void main(String[] args) {
		//[while문 활용]
		//1. 1~100까지의 숫자를 역순으로 출력.
		prn01();
		// 2. 1~100까지의 숫자 중, 2의 배수만 출력.
		prn02();
		// 3. 1~100까지의 숫자 중, 7의 배수의 갯수와 총합을 출력.
		prn03();
		
	}
	public static void prn01() {
		int i = 100;
		
		while(i>0) {
			System.out.println(i);
		}
		i--;
	}
	public static void prn02() {
		int i = 1;
		while(i<=100) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
		
	}
	public static void prn03() {
		int i = 1;
		int sum = 0;
		int cnt = 0;
		while(i<=100) {
			if(i%7==0) {
				System.out.println(i);
				sum += i;
				cnt++;
				//더하기 sum += i;
				//갯수 cnt++;
			}
			i++;
		}
	}
		
	
	
	
}
