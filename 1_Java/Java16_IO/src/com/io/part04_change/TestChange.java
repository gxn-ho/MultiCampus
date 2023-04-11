package com.io.part04_change;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestChange {
	public static void main(String[] args) {
		TestChange tc = new TestChange();
		tc.input();
	}
	
	//기반과 보조의 크기가 다를 경우 사용하는 보조 스트림
	public void input() {
		//new 보조(new 보조(new 기반("외부자원")));
		BufferedReader br
		= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("문자열 입력: ");
			String value = br.readLine();
			
			System.out.println("value: " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void output() {
		BufferedWriter bw
		= new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("java dbms jdbc");
			
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}