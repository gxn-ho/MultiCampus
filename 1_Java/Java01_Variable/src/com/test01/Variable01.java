package com.test01;

public class Variable01 {

	public static void main(String[] args) {
		
		// 준비
		// 클래스명   변수명 = new 클래스명();
		// 실행
		// 변수명, 매소드명();
		
		//준비
		Variable01 test = new Variable01();
		
		//실행
		test.declareVariable();
		test.initVariable();
		
	}
	
	// 타입 변수명 = 값 !!!
	// 타입 - 생성할 변수에 어떤 종류의 값이 들어갈지 타입 지정
	// 변수명 - 변수의 이름
	// 값 - 변수에 저장할 데이터
	public void declareVariable() {
		//변수의 선언
		
		//숫자형
		//정수형
		byte bnum;
		short snum;
		int inum;
		long lnum;
		
		//실수형
		float fnum;
		double dnum;
		
		//논리형
		boolean isTrue;
		
		//문자형
		char ch;
		
		//문자열(참조형)
		String str;
		
		//---------------------------------------
		//대입
		bnum = 1;
		snum = 2;
		inum = 4;
		lnum = 8L;
		
		fnum = 4.0f;
		dnum = 8.0;
		
		isTrue = true;
		
		ch = 'A';
		str = "A";
		
		//변수에 저장된 값 출력
		System.out.println(inum);
		System.out.println(dnum);
		System.out.println(isTrue);
		System.out.println(ch);
	}
	
	
	
	
	public void initVariable() {
		//변수 선언과 동시에 초기화
		int inum = 4;
		double dnum = 8.0;
		boolean isTrue = false;
		String str = "안녕하세요.";
		
		//변수 값 출력하기
		System.out.println(inum);
		System.out.println(dnum);
		System.out.println(isTrue);
		System.out.println(str);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
