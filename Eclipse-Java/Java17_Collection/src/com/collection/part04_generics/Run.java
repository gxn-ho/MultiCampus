package com.collection.part04_generics;

public class Run {
	public static void main(String[] args) {
		TestGenerics tg = new TestGenerics();
		//tg.testGenerics1();
		//tg.testGenerics2();
		//tg.testGenerics3();
		
		
		String[] sarr = {"apple","melon","banana","grape"};
		MyClass<String> my = new MyClass<String>(sarr);
		my.output();
		
		
		
		Integer[] iarr = {1,2,3,4,5};
		MyClass<Integer> my2 = new MyClass<Integer>(iarr);
		my2.output();
		
	}
}
