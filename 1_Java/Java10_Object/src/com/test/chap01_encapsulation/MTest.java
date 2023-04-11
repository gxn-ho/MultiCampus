package com.test.chap01_encapsulation;

public class MTest {

	public static void main(String[] args) {
		//Account 클래스 객체 하나 생성
		Account a = new Account();
		Account b = new Account();
		
		//잔액조회
		a.displayBalance();
		
		//100원, 150원 입금
		a.in(100);
		a.displayBalance();
		
		a.in(150);
		a.displayBalance();
		
		//50원 출금
		a.out(50);
		a.displayBalance();
		
		//누가 갑자기 입출금 기능 무시하고 전액 인출
		//a.balance -= 200;
		//private때문에 에러 뜸
		
		a.out(50);
		a.displayBalance();
		
		
		
		
		
		
		
	}

}
