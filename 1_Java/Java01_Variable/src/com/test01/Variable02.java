package com.test01;

import java.util.Scanner;

public class Variable02 {
			
	public static void main(String[] args) {
		//준비 : 클래스명 변수명 = new 클래스명();
		Variable02 test = new Variable02();
		
		//실행 : 변수명. 메소드명();
		test.inputTest();
		
	}
		
	public void inputTest() {
		//import java.util.Scanner;이랑 같이 쓰
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		//문자값은 nextline, 문자 숫자값은 nextint
		System.out.print("키 입력(소수점 첫째 자리까지");
		double height = sc.nextDouble();
		
		
		System.out.println(name + "님은 " + age + "세 이고, 키는 " + height + "cm입니다.");
		
		//상수 선언
		//final int age;
		
		//print와 prinln의 차이는 '줄바꿈'이다.
		
	}
	
	
	
}
