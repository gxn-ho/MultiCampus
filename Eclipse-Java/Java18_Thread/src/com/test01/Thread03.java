package com.test01;

public class Thread03 {
	public static void main(String[] args) {
		for(int i=1; i<=50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("S2");
		}
	}
}