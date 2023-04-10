package com.io.part03_addStream;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuffer {
	public void fileSave() {
		//FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			//fw = new FileWriter("sample2.txt");
			//bw = new BufferedWriter(fw);
			bw = new BufferedWriter(new FileWriter("sample2.txt"));
			// new 보조(new 기반("외부자원"));
			
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("안녕하세요\n");
			
			
			
			//bw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen() {
		try (BufferedReader br = new BufferedReader(new FileReader("sample2.txt"));){
			String val=null;
			while( (val=br.readLine()) != null ) {
				System.out.println(val);
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
	}
	
	
}
