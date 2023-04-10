package com.test03.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest2 {

	public static void main(String[] args) {
		MTest2 mt = new MTest2();
		//mt.test1();
		//mt.test2();
		//mt.test3();
		mt.test4();
	}

	public void test1() {
		//스트림 생성
		Stream<String> stream = Stream.<String>builder().add("Jung").add("Gun").add("HO").build();
		stream.forEach(System.out::println);
	}
	
	public void test2() {
		//generate() : supplier에 해당하는 람다식 활용
		Stream<String> stream = Stream.generate(()->"Hi").limit(3);

		stream.forEach(System.out::println);
		
	
	
	}
	
	public void test3() {
		//map() : 데이터를 변경, 값 변경하는 람다식을 매개변수로
		Stream<Integer> stream = IntStream.range(1, 20).boxed();
//		stream.forEach(System.out::println);
		
		stream.filter(no -> ((no%3)==0)).map(no->no*100).forEach(System.out::println);
	}
	
	public void test4() {
		List<Integer> list = IntStream.range(1, 21).boxed()
							.filter(no->no%3==0).map(no->no*5)
							.collect(Collectors.toList());
		
		System.out.println(list);
		
		
	}
	
	
	
}
