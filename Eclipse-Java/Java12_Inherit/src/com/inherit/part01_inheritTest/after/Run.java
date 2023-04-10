package com.inherit.part01_inheritTest.after;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		Television t= new Television("LG","01","T-123","LGtv",5000000,new Date(),65);;
		
		Desktop d = 
				new Desktop("삼성","02","S-1234","삼성컴퓨터",2000000, new Date(),"i9",500,32,"window11",false);
		
		System.out.println(t.information());
		System.out.println(d.information());
		
		System.out.println(d.information());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
