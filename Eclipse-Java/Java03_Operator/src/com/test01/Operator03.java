package com.test01;

public class Operator03 {
	/*
	 * 비교연산자
	 * 비교 후 조건을 만족하면 true, 만족하ㅐ지 못하면 false를 반환
	 * 
	 * <
	 * >
	 * ==
	 * !=
	 * <=
	 * >=
	 */
	public static void main(String[] args) {
		int no1 = 10, no2 = 20;
		boolean res1, res2, res3;
		
		res1 = (no1 == no2);
		res2 = (no1 <= no2);
		res3 = (no1 >= no2);
		System.out.println("res1: " +res1 + ", res2: " +res2 + ", res3: "+res3);
	}
	
	
	
	
}
