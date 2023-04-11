package com.test01;

public class DeArrayTest01 {

	public void test1() {
		//2차원 배열의 선언
		//선언을 하게 되면 stack에 레퍼런스 변수가 생성
		int[][] iarr1;
		int iarr2[][];
		
		//heap영역에 배열 할당.
		iarr1 = new int[3][5]; //정변 배열
		
		
		iarr2 = new int[3][];
		
		iarr2[0] = new int[3];
		iarr2[1] = new int[2]; //가변 배열
		iarr2[2] = new int[5];
		
		
		int val = 1;
		for(int i=0; i<iarr1.length; i++) {
			for(int j=0; j<iarr1[i].length; j++) {
				iarr1[i][j] = val++;
			}
		}
		
		
		
		
		for(int i=0; i<iarr1.length; i++) {
			for(int j=0; j<iarr1[i].length; j++) {
				System.out.print(iarr1[i][j]);
			}
			System.out.println();
		}
	}

}
