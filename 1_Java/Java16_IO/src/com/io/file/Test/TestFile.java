package com.io.file.Test;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) {
		//File클래스 테스트
		File file = new File("person.txt");
		System.out.println("파일명: " + file.getName());
		System.out.println("저장경로: " + file.getAbsolutePath());
		System.out.println("저장경로: "+ file.getPath());
		System.out.println("파일크기: "+ file.length());
		
		try {
			//파일이 없는 경우 파일 생성하고 true값 리턴
			//기존에 파일이 존재하면 false 리턴
			boolean b = file.createNewFile();
		
				
			System.out.println(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
