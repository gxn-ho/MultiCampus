package com.io.part01_byte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream {
	public void filesave() {
		FileOutputStream fout = null;
		
		try {
			fout = new FileOutputStream("sample.txt");
			
			fout.write(97);
			byte[] bar = {98,99,100,101,102,10};
			fout.write(bar);
			fout.write(bar,1,3);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void fileOpen() {
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("sample.txt");
			
//			int fileSize = (int)new File("sample.txt").length();
//			byte[] bar = new byte[fileSize];
//			
//			fin.read(bar);
//			
//			for(int i=0; i<bar.length; i++) {
//				System.out.print((char)bar[i]+" ");
//			}
			
			//byte 배열 사용하지 않고 하나씩 읽어오기
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
