package com.chap01_runtiomeExceoption;

import java.util.Scanner;

public class RunExceptionTest {
	Scanner sc = new Scanner(System.in);
	
	public void test1() {
		//RuntimeException 중에서 ArithmeticException 확인
		int ran=0;
		int res=0;
		
		
		// 1. if로 처리
		/*
		while(true) {
			System.out.print("정수 하나 입력: ");
			int inputNum = sc.nextInt();
			
			if(inputNum == 0) {
				System.out.println("0이 아닌 값을 입력하시오.");
			}else {
				if(inputNum == 11) {
					System.out.println("종료!");
					break;
				
			}
				ran=(int)(Math.random()*10)+1;
				res = ran/inputNum;
				if(res==3) {
					System.out.println("나눴을 때 3입니다. 맞췄다.");
					break;
			
			}
				
			}
			
			
			
		}*/
		
		// 2. try catch로 처리
		
		try {
			System.out.println("정수 하나 입력: ");
			int inputNum = sc.nextInt();
			ran=(int)(Math.random()*10)+1;
			res= ran/inputNum;
			System.out.printf("%d / %d = %d\n",ran,inputNum,res);
		}catch(ArithmeticException e) {
			//e.printStackTrace();
			System.out.println("Exception발생");
		}
	
		
		
		
		
		
	}
	public void test2() {
		try {
			/*
		//ClassCastException
		Object obj = 'a';
		System.out.println(obj);
		//String str = (String)obj;
		System.out.println("ㅇㅇ");
		*/
			
			
			/*
			//ArrayIndexOutOfBoundException
			int[] arr = new int[1];
			arr[0] = 1;
			arr[1] = 2;
			*/
			
			//nullPointException
			String str = null;
			int length = str.length();
			
		}catch(ClassCastException e) {
			e.printStackTrace();	
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("이건 배열 범위를 넘어가서 발생한거야!");
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("null 인디?");
		}finally {
			System.out.println("끝!!");
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}





}