package com.collection.part02_set;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	public void testHashSet() {
		HashSet hset = new HashSet();
		
		hset.add(new String("java"));
		hset.add(123);
		hset.add(45.67);
		hset.add(new Date());
		
		System.out.println("hset: " + hset);
		
		
		hset.add(new String("java"));
		hset.add(123);
		System.out.println("hset: " + hset);
		System.out.println(hset.size());
		System.out.println(hset.contains(123));
		
		//저장된 객체를 하나씩 꺼내는 기능이 없음
		//해결방법
		//1. toArray()
		Object[] arr = hset.toArray();
		for(int i=0; i<arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		
		
		//2. Iterator()
		Iterator iter = hset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		hset.clear();
		System.out.println(hset.isEmpty());
		
		
		hset.add(new Score("이창진",99));
		hset.add(new Score("김민주",88));
		System.out.println("hset: " + hset);
		
		
		//hashcode와 equals를 오버라이딩해야만
		//중복체크를 통해 중복값 허용을 하지 않는다.
		hset.add(new Score("이창진",99));
		System.out.println("hset: " + hset);
		
		
	}
	
	
	
	
	
	
	
}
