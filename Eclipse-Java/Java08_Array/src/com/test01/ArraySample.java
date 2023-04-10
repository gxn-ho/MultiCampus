/*[문제 4]
 - ArraySample 클래스에 메소드 추가함
  : 숫자로 된 문자열을 입력받아, 각 자리의 숫자들의 합을 구하여 출력
 - 메소드명 : public void test4(){}
	ex>
	문자열 입력 : 12345 //String 클래스의 substring() 메소드 사용
	합계 : 15
*/

package com.test01;

import java.util.Scanner;

public class ArraySample {
	public void test4() {

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i++) {
			String s = value.substring(i, i+1);
			int num = Integer.parseInt(s);
			sum+= num;
		}
		
		
		System.out.println(sum);
		
	}

	
/*[문제 2]
 - 메소드명 : public void munjae2()
 - 구현내용 : 
	1. 3행짜리 2차원배열 선언 및 생성
	2. 각 행별 열갯수는 키보드로 입력받아 생성함
	3. 1~100사이의 임의의 정수를 모든 방에 기록함
	4. 각 행별 열의 합계가 5의 배수인 행열값만 출력함
*/
	public void munjae2() {
		int iarr[][] = new int[3][];
		Scanner sc = new Scanner(System.in);
		int[] sum = new int[3];
		
		
		for(int i=0; i<iarr.length; i++) {
			System.out.print(i+1+"번째 의 갯수: ");
			iarr[i] = new int[sc.nextInt()];
			
			//값 기록
			for(int j=0; j<iarr[i].length; j++) {
				iarr[i][j] = (int)(Math.random()*100)+1;
				sum[i] += iarr[i][j];
			}
		}
		//출력 확인
		for(int i=0; i<iarr.length; i++) {
			for(int j=0; j<iarr[i].length; j++) {
				System.out.print(iarr[i][j] + "  ");
			}
			System.out.println();
		}
		
		//행별 합이 5의 배수인 행만 출력
		for(int i=0; i<sum.length; i++) {
			if(sum[i] % 5 == 0) {
				System.out.print(i+1+"번째 행: ");
				for(int j=0; j<iarr[i].length; j++) {
					System.out.print(iarr[i][j]+" ");
				}
				System.out.println("\t합계: " + sum[i]);
			}
		}
	}
}
