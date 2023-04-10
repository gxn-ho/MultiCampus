package com.collection.part04_generics;

//클래스 선언 시 제네릭스 지정
public class MyClass<T> {
	private T[] array;
	
	public MyClass(T[] array) {
		this.array = array;
	}
	
	public void output() {
		for(T obj : array) {
			System.out.println(obj);
		}
	}
}
