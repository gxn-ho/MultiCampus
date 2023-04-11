package com.io.part02_char;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCharStream {
	public void fileSave() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("sample.txt");
			
			fw.write("안녕하세요. 월요일 아침입니다.");
			fw.write('A');
			fw.write(' ');
			
			char[] carr = {'a','p','p','l','e'};
			fw.write(carr);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample.txt");
			
//			for(int i=0; i<100; i++) {
//				System.out.println(fr.read());
//			}
			int val=0;
			while( (val=fr.read()) != -1 ) {
				System.out.println((char)val);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
