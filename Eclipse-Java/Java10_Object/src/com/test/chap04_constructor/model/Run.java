package com.test.chap04_constructor.model;

import java.util.Date;

import com.test.chap04_constructor.model.User;

public class Run {

	public static void main(String[] args) {
		User u1 = new User();
		u1.information();
		
		User u2 = new User("user01","pass01","이창진");
		//The constructor User(String) is undefined
		u2.information();
		
		User u3 = new User("user02", "pass02", "김창진", new Date() );
		u3.information();
	}

}
