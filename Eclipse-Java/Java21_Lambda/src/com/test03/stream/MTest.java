package com.test03.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MTest {

	public static void main(String[] args) {
		//스트림 : 배열이나 컬렉션 같은 데이터를 연속적으로 하나씩 가공하거나
		//		  처리할 수 있는 코드.
		// 컬렉션에 저장된 객체(데이터)를 매우 간단한 표현식으로 처리 가능하다.
		
		//Iterator
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}
		
		//Stream
		Stream<Integer> stream = list.stream();
		stream.forEach(System.out::println);
		
		
		// ----
		ArrayList<String> list2
		= new ArrayList<>(Arrays.asList("a","b","c","d","e"));
		
		list2.stream().filter("a"::equals).forEach(System.out::println);
		
		
		
	}

}
