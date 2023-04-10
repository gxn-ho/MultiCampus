package com.test01;
import java.util.Scanner;
public class IfTest01 {
	
	public void testIf() {
		//단돈 if문
		//조건식의 결과값이 true면 {}안에 있는 코드가 실행
		//조건식의 결과값이 false면 {}안에 있는 코드를 무시하고 넘어감.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개를 입력: ");
		int num = sc.nextInt();
		
		//짝수인지 조건을 확인
		if(num % 2 == 0) {
			//true일 때 수
			System.out.println("입력하신 숫자는 짝수.");
		}
		
		//짝수가 아닌지 조건을 확인
		if(num % 2 != 0) {
			System.out.println("입력하신 숫자는 홀수.");
			
		}
		
		System.out.println("프로그램 종료");
		
		
	}
	
	public void testIfElse() {
		// if else 구문
		// 둘 중 한개를 선택하는 조건문
		// 조건이 참인 경우와 거짓인 경우에 수행하는 명령어들을 따로 작성하는 경우에 사용.
		// else에는 조건식 사용 못함
		
		int i=20;
		
		if(i<10) {
			System.out.println(i+"은 10보다 작습니다.");
		}else {
			System.out.println(i +"은 10보다 크거나 같습니다.");
		}
	}
	
	public void testIfElse2() {
		//정수 하나를 입력 받아
		//50보다 큰 수라면 크다,
		//50보다 작은 수라면 작다라고 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("0보다 큰 정수 입력: ");
		int no = sc.nextInt();
		
		/*
		if(no > 50) {
			System.out.println("50보다 큰 수");
		}else {
			System.out.println("50보다 작은 수");
		}
		*/
		
		// 정수 하나를 입력 받아
		// 50보다 큰 수라면 크다,
		// 50보다 작은 수라면 작다라고 출력
		// 단, 50보다 큰 수일 경우 짝수인지 홀수인지 출력.
		
		if(no>=50) {
			if(no%2==0) {
				System.out.println("50보다 큰 짝수");
			}else {
				System.out.println("50보다 큰 홀수");
			}
		}else {
			System.out.println("50보다 작은 수.");
		}
		
	}
		public void testElseIf() {
			int no1=10, no2=20;
			
			if(no1>no2) {
				System.out.println("no1이 no2보다 크다");
			}else if(no1<no2) {
				System.out.println("no1이 no2보다 작다");
			}else if(no1 == no2) {
				System.out.println("no1이 no2보다 작다");
			}
			
		}
		
		public void testElseIf2() {
			//점수를 하나 입력 받아 등급을 나누고 출력.
			//등급은, 90점 이상은 A 등급
			//90점 미만 80점 이상은 B등급
			//80점 미만 70점 이상은 C등급
			//70점 미만 60점 이상은 D등급
			//60점 미만은 F등급으로 나눈다.
			Scanner sc = new Scanner(System.in);
			System.out.print("점수 입력: ");
			int score = sc.nextInt();
			char grade;
			
			if(score>=90) {
				grade='A';
			}else if(score<90 && score>=80) {
				grade='B';
			}else if(score<80 && score>=70) {
				grade='C';
			}else if(score<70 && score>=60) {
				grade='D';
			}else {
				grade = 'F';
			}
			
			System.out.printf("당신의 점수는 %d이고, 등급은 %c입니다.", score, grade);

			//printf
			//System.out.printf("%형식",값(변수));
			//포맷문자
			/*
			 *  %d:정수
			 *  %f:실수
			 *  %c:문자
			 *  %s:문자열
			 *  %b:논리값
			 *  
			 *  %5d : 5칸 확보하고 오른쪽 정렬
			 *  %-5d : 5칸 확보하고 왼쪽 정렬
			 *  %.2f : 소수점 아래 2자리까지만 표
			 *  
			 */
			/*특수문자
			 * \t : 정해진 공간만큼 띄우기.
			 * \n : new line, 줄바꿈
			 * \\, \' ...
			 * 
			 */
			
			
		}
		
		
		
}