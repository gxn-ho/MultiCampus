package com.collection.part01_listSort;

import java.util.Comparator;

public class ScoreSorting implements Comparator {
	// 점수 오름차순 정렬

	
	@Override
	public int compare(Object o1, Object o2) {
		int other1 = ((Score)o1).getScore();
		int other2 = ((Score)o2).getScore();
		
		
		if(other1>other2) {
			return 1;
		}else {
			return -1;
		}

	
	}
	
}
