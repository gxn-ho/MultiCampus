package com.poly.test03;

public class MTest {
	public static void main(String[] args) {
		Animal ani = new Cat();
		ani.bark();
		ani.eat("참치");
		
		ani = new Dog();
		ani.bark();
		ani.eat("뼈다귀");
		
	}
	
}
