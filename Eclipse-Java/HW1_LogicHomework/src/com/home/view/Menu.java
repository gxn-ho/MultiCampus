package com.home.view;
import java.util.Scanner;
import com.home.controller.Function;

public class Menu {
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		Function fn = new Function();
		
		do {
			System.out.println("*** 지역변수/연산자/제어문 연습 프로그램 ***");
			System.out.println();
			System.out.println("1. 간단계산");
			System.out.println("2. 합계 구하기");
			System.out.println("3. 신상 정보");
			System.out.println("4. 학생 정보");
			System.out.println("5. 별, 숫자 출력");
			System.out.println("6. 난수까지 합계");
			System.out.println("7. 구구단");
			System.out.println("8. 주사위 숫자");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 입력");
			int no = sc.nextInt();
			
			switch(no) {
			case 1: fn.calculator();break;
			case 2: 
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9: return;
			}
		}while(true);
		
	}
	
	
	
	
	
}
