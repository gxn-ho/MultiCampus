package com.test01;

public class SwitchTest01 {
	public void test() {
		int i=2;
		
		switch(i) {
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default:
			System.out.println("다른 숫자입니다.");
		}
		
		
		switch(i) {
		case 1:
		case 3:
			System.out.println("홀수");
			break;
		case 2:
		case 4:
			System.out.println("짝수");
			break;
		}
		
		char ch = 'c';
		
		switch(ch) {
		case 'a' :
			System.out.println("a!");
			break;
		case 'b' :
			System.out.println("b!");
			break;
		case 'c' :
			System.out.println("c!");
			break;
		default  :
			System.out.println("셋 다 아님");
		}
		
		//문자열 사용
		String s = "한국";
		
		switch(s) {
		case "한국" :
			System.out.println("korea");
			break;
		case "미국" :
			System.out.println("USA");
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
