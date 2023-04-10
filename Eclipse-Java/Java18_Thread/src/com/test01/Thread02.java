package com.test01;

class MyThread02 extends Thread{
	public MyThread02(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(this.getName()+"="+i);
		}
		System.out.println(this.getName()+"끝!!");
	}
	
}

public class Thread02 {
	public static void main(String[] args) {
		MyThread02 m1 = new MyThread02("야옹");
		MyThread02 m2 = new MyThread02("멍멍");
		
		m1.setPriority(Thread.MIN_PRIORITY);
		m2.setPriority(Thread.MAX_PRIORITY);
		
		m1.start();
		m2.start();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
