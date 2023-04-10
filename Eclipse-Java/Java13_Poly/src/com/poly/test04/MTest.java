package com.poly.test04;

public class MTest {

	public static void main(String[] args) {
		Animal ani = new Cat();
		ani.bark();
		ani.eat("참치");
		
		ani = new Dog();
		ani.bark();
		ani.eat("뼈다귀");
		((Dog)ani).bite();
		
		ani = new Eagle();
		ani.bark();
		ani.eat("토끼");
		((Eagle)ani).fly();
		
		
	
	}

}
