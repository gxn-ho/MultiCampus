package com.test01;
import java.util.Scanner;
public class Operator04 {
	// &&(그리고, ~~면서)
	// ||(또는, ~~거나)
	public static void main(String[] args) {
		//1. 준비
		Operator04 o = new Operator04();
		//2. 실행
		o.test01();
	}
	
	public void test01() {
		int num = 77;
		
		//num의 값이 1~10사이인지 확인
		//1<= num <= 100 이렇게 사용 불가!
		System.out.println("1~100 확인: " + (1<=num && num<=100) );
		
		char ch = 'y';
		//ch의 값이 'y' 또는 'Y'인지 확인
		System.out.println("y인지 확인: " + (ch == 'y' || ch == 'Y'));
		
		//키보드로 입력받은 문자가 영어 대문자인지 확인
		//'A' <= 문자 && 문자 <='Z'
		//1. 스캐너 준비
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 하나 입력: ");
		char ch2 = sc.next().charAt(0);
		
		System.out.println("대문자? " + ('A'<=ch2 && ch2<='Z') );

		
	}
}
