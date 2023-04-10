package com.collection.part01_listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {
	public void scoreSort() {
		List list = new ArrayList();
		
		list.add(new Score("이창진", 99));
		list.add(new Score("김민주", 75));
		list.add(new Score("배정민", 88));
		
		list.add(new Score("김윤환", 72));
		list.add(new Score("하윤지", 64));
		list.add(new Score("매니저", 32));
		
		System.out.println("list: " + list);
		
		//1. Comparable : 기본 정렬 기준을 구현.
		//Collections.sort(list);
		list.sort(null);
		System.out.println("list: " + list);
		
		//2. Comparator :  기본 정렬 기준 이외에 정렬 기준 구현.
		list.sort(new ScoreSorting());
		System.out.println("list: " + list);
		
		
		
		
		
	}

}
