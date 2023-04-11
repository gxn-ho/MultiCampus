package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class URI01 {
	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("https://127.0.0.1:9999/image/018/2023/03/07/0005437400_001_20230307111301056.jpg?type=w647");
		
		System.out.println(u.getScheme()); //https
		System.out.println(u.getHost()); //127.0.0.1
		System.out.println(u.getPort()); //9999
		System.out.println(u.getQuery()); //type=w647
		
	
	
	}
}
