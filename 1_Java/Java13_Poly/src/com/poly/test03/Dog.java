package com.poly.test03;

public class Dog implements Animal {

	@Override
	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void eat(String animal) {
		System.out.println(animal + " 먹는다!!");
	}
	

}
