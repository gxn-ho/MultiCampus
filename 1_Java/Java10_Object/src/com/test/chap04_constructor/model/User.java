package com.test.chap04_constructor.model;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date date;
	
	//생성자의 사용목적
	//1. 객체를 생성해 주기위한 목적
	//2. 매개변수로 전달받은 값으로 필드를 초기화 할 목
	
	//기본생성자->필드의 초기화 역할은 수행하지 못하고 객체만 생성할 때 사용.
	public User() {}
	
	//매개변수 있는 생성자 -> 객체생성과 필드 초기화.
	//같은 이름의 생성자 혹은 메소드를 사용하려면 오버로딩을 활용.
	
	public User(String userId, String userPwd, String userName) {
		//this. 은 메소드 내에 숨겨진 채 존재하는 레퍼런스 변수, 할당된 객체의 주소
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		
	}
	public User(String userId, String userPwd, String userName, Date date) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd,userName);
		this.date = date;
	}
	
	// getter&setter
	public String getUserId() {
		return userId;
		//this.userId를 써도 됨.
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public Date getDate() {
		return date;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//필드값 출력용 메소드
	public void information() {
		System.out.println(userId+", "+userPwd+", "+userName+", "+date);
	}
	
	
	
	
}
