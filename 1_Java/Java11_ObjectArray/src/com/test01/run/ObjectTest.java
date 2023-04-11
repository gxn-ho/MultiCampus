package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectTest {

	public static void main(String[] args) {
		//public Book(String title, String writer, String publisher, int price)
		Book bk1 = new Book("자바의 정석","홍길동","한빛",20000);
		Book bk2 = new Book("이것이 자바다","신용권","한빛미디어",30000);
		Book bk3 = new Book("이것이 MySQL이다","이창진","multi",40000);
		
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		System.out.println(bk3.information());
		
		//도서 검색
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 책 제목: ");
		String searchTitle = sc.nextLine();
		
		if(bk1.getTitle().equals(searchTitle)) {
			System.out.println(bk1.information());
		}else if(bk2.getTitle().equals(searchTitle)) {
			System.out.println(bk2.information());
		}else if(bk3.getTitle().equals(searchTitle)) {
			System.out.println(bk3.information());
		}
		
	}

}
