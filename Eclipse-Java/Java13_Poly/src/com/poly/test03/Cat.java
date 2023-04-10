package com.poly.test03;

public class Cat implements Animal {

	@Override
	public void bark() {
		System.out.println("야옹");
	}

	@Override
	public void eat(String animal) {
		System.out.println(animal+" 먹는다!");
	}
	
}
