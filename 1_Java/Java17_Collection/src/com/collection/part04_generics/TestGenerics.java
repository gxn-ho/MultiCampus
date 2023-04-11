package com.collection.part04_generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestGenerics {
	public void testGenerics1() {
		List list = new ArrayList();
		
		//컬렉션에는 여러 종류의 객체를 저장할 수 있다.
		list.add(new String("Object"));
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		System.out.println("저장된 객체 수:"+list.size());
		System.out.println(list);
		
		//저장된 객체를 꺼내서 사용할 때
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj.toString());
			if(obj instanceof Book) {
				((Book)obj).printBook();
			}
			if(obj instanceof Student) {
				((Student)obj).score();
			}
			if(obj instanceof Car) {
				((Car)obj).printCar();
			}
			
			
		}
	}
	public void testGenerics2() {
		//제네릭스 : 컬렉션에 저장되는 객체의 자료형에 제한을 거는 기능
		
		List<Book> list = new ArrayList<>();
		List list2 = new ArrayList();
		
		
		//list.add("test test");
		list.add(new Book());
		list.add(new Book());
		
		list2.add(new Book());
		list2.add(new Book());
		
		for(Book b : list) {
			b.printBook();
		}
		for(Object b : list2) {
			((Book)b).printBook();
		}
		
		
		
		
	}
	
	public void testGenerics3() {
		//Map
		Map<String, Book> map = new HashMap<String,Book>();
		map.put("one", new Book());
		map.put("two", new Book());
		map.put("three", new Book());
		
		System.out.println(map);
		
		//Iterator 이용하여 처리
		Set<Entry<String,Book>> entry = map.entrySet();
		
		Iterator<Entry<String,Book>> iter = entry.iterator();
		while(iter.hasNext()) {
			Entry<String,Book> ent = iter.next();
			String key = ent.getKey();
			Book val = ent.getValue();
			System.out.println(key+"="+val);
		}
		
	}
	
		
	
	
	
	
	
	
	
}


class Book {
	private String title;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public void printBook() {
		System.out.println("printBook() call...");
	}
	@Override
	public String toString() {
		return "Book";
	}
}
class Student {
	public Student() {}
	public void score() {
		System.out.println("score() call...");
	}
	@Override
	public String toString() {
		return "Student";
	}
}
class Car {
	public Car() {}
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "Car";
	}
}














