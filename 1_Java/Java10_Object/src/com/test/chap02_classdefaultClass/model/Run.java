package com.test.chap02_classdefaultClass.model;


public class Run {

	public static void main(String[] args) {
		
		//DefaultClassTest 클래스 객체 생성 후 test() 실행
		//default클래스는 해당 패키지를 제외한 외부에서는 접근이 불가능.
		DefaultClassTest test = new DefaultClassTest();
		//Default클래스는 같은 패키지에서 사용 가능.
		test.test();
		
		
	}

}
