package com.collection.part03_map.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public void testProp() {
		Properties prop = new Properties();
		
		prop.setProperty("driver", "com.mysql.jdbc.Driver");
		prop.setProperty("url", "jdbc:mysql://localhost/multi");
		prop.setProperty("id", "root");
		prop.setProperty("pw", "1234");
		
		System.out.println(prop);
		
		try {
			prop.store(new FileOutputStream("drive.properties"), "jdbc driver");
			prop.store(new FileWriter("driver.txt"), "jdbc driver");
			prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void testProp2() {
		//파일로부터 데이터를 읽어와 Properties에 저장
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("driever.properties"));
			
			System.out.println(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("id"));
			System.out.println(prop.getProperty("pw"));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}



}
