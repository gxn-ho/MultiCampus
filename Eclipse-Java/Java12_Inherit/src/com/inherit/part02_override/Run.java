package com.inherit.part02_override;

public class Run {

	public static void main(String[] args) {
		Book b1 = new Book("수학의 정석","이창진",100);
		Book b2 = new Book("이것이 자바다","홍길동",200);
		
		
		System.out.println("b1= "+ b1);
		System.out.println("b2= "+ b2);
		
		System.out.println(b1.equals(b2));
		
		Book b3 = b1;
		System.out.println(b1.equals(b3));
		
		Book b4 = new Book("수학의 정석","이창진",100);
		System.out.println("b1과 b4는 같은 객체? "+b1.equals(b4));
		
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
		
	}

}
