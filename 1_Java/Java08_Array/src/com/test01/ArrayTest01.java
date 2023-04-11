package com.test01;
import java.util.Scanner;
public class ArrayTest01 {

	public void testArray() {
		//배열의 사용 이유
			/*
			int num1 = 10;
			int num2 = 20;
			int num3 = 30;
			int num4 = 40;
			int num5 = 50;
				
			int sum = 0;
				
			sum += num1;
			sum += num2;
			sum += num3;
			sum += num4;
			sum += num5;
			*/
			
			//배열 이용
			int[] arr = new int[5];
			
			/*
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 30;
			arr[3] = 40;
				arr[4] = 50;
			*/
			for(int i=0; i<5; i++) {
				arr[i] = (i*1)*10;
				
			}
			int sum=0;
			/*
			sum += arr[0];
			sum += arr[1];
			sum += arr[2];
			sum += arr[3];
			sum += arr[4];
			*/
			for(int i=0; i< arr.length; i++) {
				sum += arr[i];
			}
			
			System.out.println("sum : " + sum);
	}
	
	public void testArray2() {
		//배열 선언
		//자료형[] 변수명(배열명);
		//자료형 변수명[];
		
		//stack 영역에 배열의 주소를 보관할 수 있는 공간을 만드는 것.
//		int[] iarr;
//		char carr[];
//		
//		iarr = new int[5];
//		carr = new char[10];
		
		//선언과 할당을 동시에 사용
		int iarr[] = new int[5];
		char[] carr = new char[10];
		
		
		System.out.println("iarr: " + iarr);
		System.out.println("carr: " + carr);
		
		System.out.println("iarr의 hashcode: " + iarr.hashCode());
		System.out.println("carr의 hashcode: " + carr.hashCode());
		
		
		System.out.println("iarr의 길이: " + iarr.length);
		System.out.println("carr의 길이: " + carr.length);
		
		//스캐너로 입력받은 정수값으로 배열의 길이 지정하여 할당.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("새로 할당할 배열의 길이를 입력하세요: ");
		int size = sc.nextInt();
		
		double darr[] = new double[size];
		
		System.out.println("darr의 hashcode: " + darr.hashCode());
		System.out.println("darr의 길이: " + darr.length);
		
		// 배열의 크기 변경은 불가. 새로운 배열 생성하여 주소값을 덮어 씌운 것.
		darr = new double[30];
		System.out.println("darr의 hashcode: " + darr.hashCode());
		System.out.println("darr의 길이: " + darr.length);
		
		//한번 할당된 배열을 내가 직접 지울 수 없다.
		//더이상 참조하지 않는 배열은 일정 시간이 지난 후 old 영역으로 이동하여
		//gc(가비지컬렉터)가 삭제시킨다.
		darr = null;
		
		// NullPointerException
		// 아무것도 참조하고 있지 않고, null이라는 특수 값을 가지고 있을 때 발생하는 에러.
		System.out.println("삭제 후 darr의 길이: " + darr.length);
		
	}
	
	public void testArray3() {
		int[] iarr = new int[5];
		
		//0으로 초기화되어 있다.
		for(int i=0; i<iarr.length; i++) {
			System.out.println("iarr["+i+"]의 값: " + iarr[i]);
		}
		
		
		//지정된 기본값 이외의 값으로 초기화
		// { }
		int iarr2[] = {11,22,33,44};
		
		System.out.println(iarr2.length);
		System.out.println(iarr2[0]);
		
		String[] sarr = new String[] {"사과","고구마","감자","바나나","토마토"};
		
		for(int i=0; i<sarr.length; i++) {
			System.out.println(sarr[i]);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
