package com.test.chap03_field.test01;

//static
public class KindsOfVariable02 {
	//전역 변수에서 static 키워드 사용 가능
	public static int staticNum;
	
	//public 접근제한자에다가, static과 final 키워드를 함께 사용하는 것을 '상수필드'라고 한다.
	//상수필드는 선언과 동시에 초기화 되어야 한다.
	public static final int STATIC_NUM = 1;
	//프로그램 시작시 값이 저장되면 변경하지 않고 지속적으로 사용할 목적으로 사용.
	
	public final static int STATIC_NUM2 = 2;
	
	
	
	public void methodTest() {
		//static int localStaticNum=1;
	}
	public static void methodTest2() {
		//static int localStaticNum=1;
	}
	
	
}
