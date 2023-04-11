package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URI02 {
	public static void main(String[] args) throws IOException {

			URL url = new URL("https://imgnews.pstatic.net/image/018/2023/03/07/0005437400_001_20230307111301056.jpg?type=w647");
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
	
			DataInputStream di = 
					new DataInputStream(urlConnection.getInputStream());
			
			FileOutputStream fo = 
					new FileOutputStream("a.jpg");
			
			byte[] b = new byte[1];
			
			while(di.read(b,0,1) != -1) {
				fo.write(b,0,1);
			}
			System.out.println("완료");
			di.close();
			fo.close();
			
			
			
			
	}

}
