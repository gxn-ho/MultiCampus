package com.test01;

import java.util.Scanner;

public class ForTest01 {
	public static void main(String[] args) {
		//testFor();
		//testFor2();
		//testFor3();
		//testFor4();
		testFor5();
	}
	
	public static void testFor() {
		// 0~10까지 출력
		/*	for(초기식;조건식;증감){
		*	반복 할 코드
		*	} 
		*/
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}
		
	}
	
	public static void testFor2() {
		// 역순으로 출력
		for(int i=100; i>0; i--) {
			System.out.println(i+" ");
		}
		
	}
	public static void testFor3() {
		// 1~100까지 짝수(2의 배수)만 출력
		// 증감식은 반드시 1씩 증감할 필요가 없다.
		for(int i=2; i<=100; i+=2 ) {
				System.out.println(i+" ");
		}
		System.out.println();
		// 초기식과 증감식은 1개 이상 작성 가능
		// 조건식은 무조건 하나(true or false가 나와야 함)
		// '&&나 ||'를 쓴다면 사용 가능
		for(int i=0, j=100; i<10 && j>0; i++, j--) {
			System.out.println(i);
			System.out.println(j);
		}
		
		// int가 아니라 char로도 반복문을 사용할 수 있다.
		for(char ch = 'a'; ch<='z'; ch++) {
			System.out.println(ch + " ");
		}
		
	}
		
		public static void testFor4() {
			int i=1;
			for(;;) {
				System.out.print(i+ " ");
				i++;
				if(i==10) {
					break;
				}
			}
			System.out.println();
			//정수 하나 입력.
			//정수 하나 입력. 그 수가 양수일 때만 그 수의 구구단을 출력.
			//양수가 아니면 "반드시 1~9사이의 양수를 입력하세요!!"라고 출
			
			Scanner sc = new Scanner(System.in);
			System.out.print("1~9사이의 양수 하나 입력: ");
			int dan = sc.nextInt();
			
			if(dan >= 1 && dan <= 9) {
				//구구단 출력
				for(int j = 1; j<10; j++) {
					System.out.println(dan + "*"+j+"="+(dan*j));
				}
			}else {
				System.out.println("반드시 1~9사이의 양수를 입력하세요!!");
			}
			
			
			
			
		}
		
		public static void testFor5() {
			// 1~100사이의 임의의 난수를 하나 구하고
			// 1부터 구한 수까지의 합을 출력
			
			int random = (int)(Math.random()*100)+1;
			//Math.random 0.0 ~ 0.999...
			//*100		  0.0 ~ 99.99...
			//int 형변환	  0.0 ~ 99 (소수점 사라짐)
			//+1		  1 ~ 100
			
			int sum = 0;
			for(int i=1; i<=random; i++) {
				sum += i;
			}
			System.out.println("1부터 " + random +"까지의 정수들의 합: "+ sum);
		}
		
		public static void testFor6() {
			// 정수 두개 입력 후
			// 작은 수 ~ 큰 수까지의 합을 구하여 출력
			// 1. 정수 두개 입력
			// 2. 큰 수와 작은 수를 찾아
			// 3. 작은 수부터 큰 수까지 합을 구하자.
			Scanner sc = new Scanner(System.in);
			
			System.out.print("첫번째 정수: ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수: ");
			int num2 = sc.nextInt();
			
			int sum=0;
			
			if(num1>num2) {
				for(int i = num2; i<=num1; i++) {
					sum += i;
				}
			}else {
				for(int i = num1; i<=num2; i++) {
					sum += i;
				}
			}
			System.out.println(sum);
			
			
			// 1.
			
//			max = Math.max(num1, num2);
//			min = Math.min(num1, num2);
//			for(int i=min; i<=max; i++) {
//				sum += i;
//			}
			
			// 2.
			
//			if(num1>num2) {
//				max=num1;
//				min=num2;
//			}else {
//				max=num2;
//				min=num1;
//			}
			
			
			
		}
		
	
	
	
	
	
	
	
}
