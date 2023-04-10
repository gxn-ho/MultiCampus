package com.test01;

class MyThread implements Runnable{

	@Override
	public void run() {
			for(int i=0; i<100; i++) {
				System.out.println("i = " + i);
			}
	}
	
}

public class Thread01 {
	public static void main(String[] args) {
		System.out.println("--- main start ---");
		
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
//		m1.run();
//		m2.run();
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		
		//Thread.start() -> 자동으로 run() 호출
		t1.start();
		t2.start();
		
		
		System.out.println("--- main stop ---");
		
	}
	
	
	
}
