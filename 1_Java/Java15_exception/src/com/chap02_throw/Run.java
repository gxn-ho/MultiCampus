package com.chap02_throw;

import java.io.IOException;

public class Run {

	public static void main(String[] args) /*throws IOException*/ {
		try {
			methodA();
		} catch (IOException e) {
			System.out.println("main()에서 처리");
		}
		
	}
	
	public static void methodA() throws IOException {
		methodB();
	}
	
	public static void methodB() throws IOException {
		methodC();
	}
	
	public static void methodC() throws IOException {
//		try {
//			throw new IOException();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		throw new IOException();
		
	}

}
