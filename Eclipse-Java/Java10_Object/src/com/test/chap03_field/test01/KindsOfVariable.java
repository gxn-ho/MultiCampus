package com.test.chap03_field.test01;

public class KindsOfVariable { //클래스 영역의 시작
	//클래스 영역에 작성하는 변수를 필드.
	//필드 == 멤버변수(클래스가 가지는 멤버라는 의미) == 전역변수(클래스 전역에서 사용할 수 있는 변수)
	private int globalNum;
	
	public void testMethod(int num) {//메소드 영역의 시작
		//메소드 영역에서 작성하는 변수를 지역변수.
		//메소드의 괄호 안에 선언하는 변수를 매개변수(매개변수도 일종의 지역 변수라고 생각)
		int localNum;
		
		System.out.println(num);
		
		//지역변수는 선언 외에 다시 사용하기 위해서는 반드시! 초기화가 되어야 한다.
		//System.out.println(localNum);
		//초기화하면 localNum 사용 가능
		
		System.out.println(globalNum); //전역변수는 클래스 전역에서 사용 가능
		
	}//메소드 영역의 끝
	public void testMeethod2() {
		// System.out.println(localNum); 지역변수는 해당 지역(블럭)내에서만 사용 가능하다.
		System.out.println(globalNum);
		
	}
	
	
	
}//클래스 영역의 끝
