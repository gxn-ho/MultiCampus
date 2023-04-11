package com.test02;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functional {

	public static void main(String[] args) {
		// Function : 매개변수o, 반환값o	R apply(T t)
		Function<Integer, String> time = n -> (n<10)?"0"+n :""+n;
		System.out.println(time.apply(1));
		System.out.println(time.apply(2));
		System.out.println(time.apply(10));
		
		// R apply(T t, U u)
		BiFunction<String, String, Integer> sum
				= (i,j) -> Integer.parseInt(i) + Integer.parseInt(j);
		
		System.out.println(sum.apply("10", "20"));
				
		//supplier : 매개변수 X, 반환O
		Supplier<Integer> rnum = () -> (int)(Math.random()*45)+1;
		System.out.println(rnum.get());
				
		//consumer : 매개변수 O, 반환X
		Consumer<String> hello = (name) -> System.out.println("Hello, " + name);
		hello.accept("Lambda");
		
		BiConsumer<String, Integer> class604
			= (name, score) -> System.out.printf("%s의 java 점수는 %d점 입니다.", name,score);
		class604.accept("정건호", 100);	
			
				
				
				
				
				
				
				
	}

}
