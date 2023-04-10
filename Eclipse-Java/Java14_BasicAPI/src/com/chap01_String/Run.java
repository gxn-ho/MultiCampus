package com.chap01_String;

public class Run {

	public static void main(String[] args) {
		//method1();
		method2();
	}
	
	public static void method1() {
		//1. 문자열을 리터럴로 생성
		String str = "abc";
		String str1 = "abc";

		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		
		//2. 생성자를 통한 문자열 생성
		String str2 = new String("abc");
		String str3 = new String("abc");
		
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		
		// -----
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		
		System.out.println("new 사용");
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));

	}
	
	public static void method2() {
		String str = "abc";
		// concat() 합치기
		System.out.println(str.concat("def"));
		System.out.println(str);
		//contains() 포함 여부
		System.out.println(str.contains("a"));
		//split() 자르기
		String str1 = "a,b,c,d";
		String[] sArr = str1.split(",");
		for(String ar : sArr) {
			System.out.println(ar);
			
		}
		
		//toUpperCase() 대문자로
		System.out.println(str.toUpperCase());
		
		String str2 = "   ab c   ";
		//trim() 공백 제거
		System.out.println(str2);
		System.out.println(str2.trim());
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
