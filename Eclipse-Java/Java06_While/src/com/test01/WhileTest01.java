package com.test01;
import java.util.Scanner;
public class WhileTest01 {
	public void testWhile() {
		int i=1;
		
		while(i<10) {
			System.out.println(i+"번째 반복문 수행");
			i++;
			
		}
		
		System.out.println("while 종료 후 i: " + i);
	}
	
	public void testWhile2() {
		
		int i = 1;
		String str="abcdef";
		
		while(i<7) {
			char ch = str.charAt(i-1/*i일 때는 a=0이지만, i-1이면 a=1이다*/);
			System.out.println(i + ":" + ch);
			i++;
		/*while(i<str.length()) {
			char ch = str.charAt(i);
			System.out.println(i + ":" + ch);
			i++;
		*/
		}
	}
	
	
	public void testWhile3() {
			
		int i=1;
			
		while(true) {
			System.out.println(i);
			i++;
				
			if(i==10) {
				break;
			}
				
		}	
		System.out.println("종료 후 i : " + i);
			
	}
	
	public void testWhile4() {
		//키보드로 4를 입력 받을 때까지 반복
		//4가 입력되면 while문 종
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자입력: ");
			int no = sc.nextInt();
			
			if(no == 4) {
				System.out.println("4! 종료!");
				break;
			}
			
			
		}
		
	 }
	
	public void testWhile5() {
		//1부터 입력받은 수까지 정수들의 합을 구하여 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 하나 입력: ");
		int num = sc.nextInt();
		int sum = 0;
		int i = 1;
		while(i <= num) {
			sum+=i; // sum = sum+i;
			i++;
			
			
		}
		System.out.println("sum: " + sum);
		
		
		
	}
	
	
	
}
