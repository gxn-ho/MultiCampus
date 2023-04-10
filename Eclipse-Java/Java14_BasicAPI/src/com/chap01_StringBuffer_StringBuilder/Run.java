package com.chap01_StringBuffer_StringBuilder;

public class Run {

	public static void main(String[] args) {
		//method1();
		//method2();
		method3();
	}
	
	public static void method1() {
		StringBuilder sb = new StringBuilder("안녕 반가워");
		System.out.println(sb);
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		
		
	}
	
	public static void method2() {
		String str = "반가워! ";
		System.out.println(System.identityHashCode(str));
		str += "난 String이라고 해";
		System.out.println(System.identityHashCode(str));
		
		StringBuffer sbf = new StringBuffer("안녕! ");
		System.out.println(System.identityHashCode(sbf));
		sbf.append("난 StringBuffer야");
		System.out.println(System.identityHashCode(sbf));
		
		
		
		
		
	}
	
	
	public static void method3() {
		StringBuilder sb = new StringBuilder("난 ");
		
		
		System.out.println(sb);
		
		//append
		sb.append("잠이 온다").append("~!");
		//insert
		sb.insert(0, "늦게 잠을 자느라 ");
		//delete
		sb.delete(0, 10);
		//reverse
		sb.reverse();
		
		
		System.out.println(sb);
		
		
		
	}
	
	
}
