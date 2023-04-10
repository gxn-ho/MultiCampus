package com.test.chap03_field.test02;

// 초기화 블럭
public class InitBlock {
	// 필드를 초기화 하지 않으면 기본값으로 객체가 초기화 되면서 생성.
	
	
	//1. jvm 기본값 초기화
//	private String name;
//	private int price;
//	private static String brand;
	
	
	//2. 명시적 초기화
	private String name = "아이폰";
	private int price = 1700000;
	private static String brand = "애플";
	
	
	//3. 초기화 블럭
	{
		name = "갤럭시";
		price = 1200000;
		brand = "삼성";
	}
	static {
		/*name = "플립";
		price = 1500000;
			static 초기화 블럭에서는 non-static 필드 초기화 불가능
		*/
		brand = "samsung";
	}
	
	public InitBlock() {} //생성자
	
	//4.매개변수 있는 생성자
	//위의 초기화되는 값을 다 덮어쓰고 전달받은 값으로 초기화 진행.
	public InitBlock(String name, int price, String brand) {
		this.name = name;
		this.price = price;
		InitBlock.brand = brand;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	
	public void information() {
		System.out.println(name +", "+price+", "+brand);
		
	}
	
	
	
	
	
	
	
	
	
}
