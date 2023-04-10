package com.test.chap01_encapsulation;

public class Account {
	//필드 (정보)
	private String name = "정건호";
	private String accNo = "010-9379-9737";
	private String pwd = "1234";
	private int balance = 0;
	
	//메소드 (기능)
	//생성자(객체를 생성하기 위하여 일종의 메소드)
	public Account() {	}

	//입금
	public void in(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name+"님의 계좌에 " + money + "원이 입금되었습니다.");
		}else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
	}
		
	//출금
	public void out(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.println(name+"님의 계좌에 " + money + "원이 출금되었습니다.");
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
	}
	
	//잔액조회
	public void displayBalance() {
		System.out.println(name+"님의 계좌에 잔액은 "+ balance + "원 입니다.");
	}
		
		
}