package com.test01;

//형변환
public class Variable04 {
	//프로그램의 시작점
	public static void main(String[] args) {
		//1.준비
		// 클래스명 변수명 = new 클래스명();
		Variable04 test = new Variable04();
		//2.실행
		// 변수명.메소드명();
		//test.test1();
		test.test2();
	}
	
	public void test1() {
		int num = 'A';
		//자동 형변환 : 문자 A가 숫자로 변환되서 나옴
		System.out.println(num);
		
		char ch = 97;
		System.out.println(ch);
		
		//ch = -97;
		//음수값 저장 불가
		
		//int 자료형 변수의 값은 강제 형변환 해야한다.
		char ch2 = (char)num;
		System.out.println(ch2);
		
		int no=-97;
		char ch3 = (char)no;
		System.out.print(ch3);
	}
		
	public void test2() {
		int inum = 10;
		long lnum = 100;
		
		//int isum = inum + lnum;
		
		//두 변수 연산 후 isum에 담으려면 에러 발생
		//int isum = inum + lnum;
		
		//1.
		int isum = (int)(inum+lnum);
		System.out.println(isum);
		
		//2.
		int isum2 = inum + (int)lnum;
		System.out.println(isum2);
		
		//3.
		long lsum = inum+lnum;
		System.out.println(lsum);
		
	}
	
	
	
	
	
}
