package com.inherit.part01_inheritTest.after;

import java.util.Date;

public class Television extends Product {
	private int inchType;
	
	public Television() {
		super();
	}

	public Television(String brand, String productNumber, String productCode, String productName, int price, Date date,
			int inchType) {
		super(brand, productNumber, productCode, productName, price, date);
		this.inchType = inchType;
		
		System.out.println("product를 상속받은 television 클래스 생성자 호출 완료...");
		
	}

	public int getInchType() {
		return inchType;
	}

	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	public String information() {
		return super.information()+", "+inchType;
	}
	
	
	
	
}
