package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectArrayTest {
	public static void main(String[] args) {
		
		//선언 및 할당
		//Book[] bk = new Book[3];
		
		//초기화
//		bk[0] = new Book();
//		bk[1] = new Book();
//		bk[2] = new Book();
		
		//선언 및 할당과 동시에 초기화까지
		Book[] bk = {
				new Book("자바의 정석","홍길동","한빛",20000),
				new Book("이것이 자바다","신용권","한빛미디어",30000),
				new Book("이것이 MySQL이다","이창진","multi",40000)
		};
		System.out.println(bk); //배열의 주소
		System.out.println(bk[0]); //Book클래스 객체의 주소 ( Book )
		System.out.println(bk[0].getPrice()); //필드 price의 값 ( int )
		
		System.out.println();
		
		//도서 출력
		for(int i=0; i<bk.length; i++) {
			System.out.println(bk[i].information());
		}
		
		
		//도서 검색
		//제목 입력 받아 저장된 book 객체의 title값과 동일하면 information 실행
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 책 제목: ");
		String searchTitle = sc.nextLine();
				
		for(int i=0; i<bk.length; i++) {
			if(bk[i].getTitle().equals(searchTitle)) {
				System.out.println(bk[i].information());
				break;
			}
		}
		
		
		
		
		
		
		
		
	}

}
