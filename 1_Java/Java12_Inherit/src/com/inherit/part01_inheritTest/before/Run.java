package com.inherit.part01_inheritTest.before;

import java.util.Date;

public class Run {
	public static void main(String[] args) {
		Television t = new Television("LG","01","T-01234","LGtv",5000000,new Date(), 65);
		
		Desktop d = new Desktop("삼성","02","D-1234","i9",500,64,"window11",200000,new Date(), false);
		
		System.out.println(t.information());
		System.out.println(d.information());		
		
	}
	
	
}