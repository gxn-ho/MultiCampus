package com.test.chap03_field.test02;

public class Run {

	public static void main(String[] args) {
		InitBlock ib = new InitBlock();
		ib.information();
		
		InitBlock ib2 = new InitBlock("폴더",2500000,"SAMSUNG");
		ib2.information();
		
		ib2.setName("하하하");
		ib2.information();
	}

}
