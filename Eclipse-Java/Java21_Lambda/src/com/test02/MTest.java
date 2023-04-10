package com.test02;

public class MTest {
	public static void main(String[] args) {
		MyCalc sum = (a,b) -> a+b;
		MyCalc sub = (a,b) -> a-b;
		MyCalc mul =(a,b) -> a*b;
		MyCalc div =(a,b) -> a/b;
		
		System.out.printf("%d + %d = %.0f\n", 10, 3,sum.calc(10,3));
		System.out.printf("%d / %d = %.0f\n", 10, 3,div.calc(10,3));
		
	}

}
