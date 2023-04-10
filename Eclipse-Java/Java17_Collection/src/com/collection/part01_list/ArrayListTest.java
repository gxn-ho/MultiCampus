package com.collection.part01_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.collection.part01_listSort.Score;


public class ArrayListTest {
	public void testArryList() {
		ArrayList alist = new ArrayList();
		
		//다형성 적용하여 객체 생성 가능
		List list = new ArrayList();
		Collection clist = new ArrayList();
		
		
		alist.add("apple");
		alist.add(123);		//autoboxing(리터럴값->객체)
		alist.add(45.67);
		alist.add(new Date());
		
		System.out.println("alist: " + alist);
		

		
		for(int i=0; i<alist.size(); i++) {
			System.out.println(i+" : " + alist.get(i));
		}
		
		alist.add("apple");
		System.out.println("alist : " + alist);
		
		alist.add(1,"banana");
		System.out.println("alist : " + alist);
		
		alist.remove(2);
		System.out.println("alist : " + alist);
		
		alist.set(1, new Boolean(true));
		System.out.println("alist : " + alist);
		
		
	}
	
	public void testGenerics() {
		ArrayList list = new ArrayList();
		ArrayList<Score> list2 = new ArrayList<Score>();
		
		list.add("list");
		list.add(123);
		list.add(new Score());
		
		list2.add(new Score());
		list2.add(new Score());
		//list2.add("list");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
