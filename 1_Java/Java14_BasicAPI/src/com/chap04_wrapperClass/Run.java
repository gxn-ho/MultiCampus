package com.chap04_wrapperClass;

public class Run {

	public static void main(String[] args) {
		//boxing
		Integer i = new Integer(10);
		Double d = new Double(15);
		//autoBoxing
		Integer i2 = 15;
		
		System.out.println(i.equals(i2));
		System.out.println(i.compareTo(i2));
		//같을 때 0, i2가 크면 음수, i가 크면 양수
		
		//unBoxing
		int pi = i.intValue();
		double pd = d.doubleValue();
		//autoUnBoxing
		int a = i;
		int b = i2;
		
		abox(a+b);
		//int >> autoBoxing >> Integer >> 다형성 >> Object
	}
	
	public static void abox(Object obj) {
		System.out.println(obj);
		System.out.println((Integer)obj);
		System.out.println((int)obj);
		
	}
	
	
	
	
	

}
