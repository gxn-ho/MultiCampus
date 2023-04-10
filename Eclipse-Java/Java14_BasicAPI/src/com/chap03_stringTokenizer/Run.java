package com.chap03_stringTokenizer;

import java.util.StringTokenizer;

public class Run {
	// countToken: 토큰 수 파악, nextToken: 토큰 읽어오기
	// hasMoreTokens: 토큰이 남아있는지 확인 후 boolean값 리턴

	public static void main(String[] args) {
		String str = "이창진,19,경기도 화성시,남";
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
