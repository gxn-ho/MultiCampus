package com.test01;

public class ArrayTest02 {

	public String prn/*매개변수 하나 받아서 출력*/(int[] iarr) {
		
		String str = "";
		
		for(int i=0; i<iarr.length;i++) {
			str += iarr[i]+" ";
			
		}
		//System.out.println("prn hashcode: " + iarr.hashCode());
		return str;
	}
	
	public void shallowCopy() {
		//얕은 복사
		int[] oArr = {1,2,3,4,5};
		int[] cArr = oArr;
		
		System.out.println("1.oArr : " + prn(oArr));
		System.out.println("1.cArr : " + prn(cArr));
		
		
		oArr[0] = 99;
		System.out.println("1.oArr : " + prn(oArr));
		System.out.println("1.cArr : " + prn(cArr));
		
		System.out.println("oArr의 hashcode: " + oArr.hashCode());
		System.out.println("cArr의 hashcode: " + cArr.hashCode());
		
	}
	
	
	//깊은 복사
	public void deepCopy1() {
		//1. 동일한 배열을 새로 하나 생성하여 값을 복사.
		
		int[] oArr= {1,2,3,4,5};
		int[] cArr= new int[5];
		
		//for문을 이용해서 값을 1:1로 복사
		for(int i=0; i<oArr.length; i++) {
			cArr[i] = oArr[i];
		}
		
		System.out.println("oArr : " + prn(oArr));
		System.out.println("cArr : " + prn(cArr));
		
		oArr[0] = 99;
		
		System.out.println("oArr : " + prn(oArr));
		System.out.println("cArr : " + prn(cArr));
		
		System.out.println(oArr.hashCode());
		System.out.println(cArr.hashCode());
	
	}
	
	public void deepCopy2() {
		//2.arraycopy() 사용
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[10];
		
		//arraycopy(src,srcPos,dest,destPos,length);
		//src: 원본 배열, srcPos: 복사 시작 위치
		//dest: 카피배열, destPos: 붙여넣기 시작 위치
		//length: 복사할 길이
		
		System.arraycopy(oArr,0,cArr,2,oArr.length);
		
		System.out.println("oArr : " + prn(oArr));
		System.out.println("cArr : " + prn(cArr));
		
		//3. clone()
		//시작인덱스 등의 설정이 불가능, 원본 배열을 통째로 복사해 새로운 배열을 할당.
		int[] cArr2 = new int[10];
		
		System.out.println(cArr2.hashCode());
		
		cArr2 = oArr.clone();
		
		System.out.println(cArr2.hashCode());
		System.out.println("cArr2 : " + prn(cArr2));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
