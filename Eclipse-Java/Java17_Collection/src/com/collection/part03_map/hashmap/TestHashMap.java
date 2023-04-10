package com.collection.part03_map.hashmap;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public void testHashMap() {
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Date());
		hmap.put(12, "red apple");
		hmap.put(33, 123);
		
		System.out.println("hmap: " + hmap);
		
		//키는 중복 저장되지 않는다.(set)
		hmap.put(12, "yellow banana");
		System.out.println("hmap: " + hmap);
		
		//벨류는 중복 저장된다(list)
		hmap.put(11, "yellow banana");
		hmap.put(9, "yellow banana");
		System.out.println("hmap: " + hmap);
		
		System.out.println("키 9의 벨류: " + hmap.get(9));
		
		hmap.remove(9);
		System.out.println("hmap: " + hmap);
	}
	
	public void testHashMap2() {
		//Map에 저장된 정보 연속처리
		
		HashMap map = new HashMap();
		
		map.put("one", "java 11");
		map.put("two", "mysql8");
		map.put("three", "jdbc");
		map.put("four", "html15");
		map.put("five", "css3");
		
		
		//1. keySet() 이용해서 key만 따로 set으로 만들고,
		//iterator() 사용하여 목록 만듦.
		Set keys = map.keySet();
		Iterator keyIter = keys.iterator();
		
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			String value = (String)map.get(key);
			System.out.println(key+" : "+value);
		}
		
		//2. value만 values()로 처리
		Collection values = map.values();
		
		//2.1 iterator()
		Iterator valIter = values.iterator();
		while(valIter.hasNext()) {
			System.out.println(valIter.next());
		}
		
		//2.2 배열로 만들어서 처리
		Object[] arr = values.toArray();
		for(int i=0; i<arr.length; i++) {
			System.out.println(i+":"+arr[i]);
		}
		
		//3. Map의 내부클래스인 EntrySet 이용 : entrySet();
		Set set = map.entrySet();
		Iterator entryIter = set.iterator();
		
		while(entryIter.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIter.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
