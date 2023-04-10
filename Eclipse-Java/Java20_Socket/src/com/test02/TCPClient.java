package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader stdIn = null;
		
		System.out.println("server에 접속합니다...");
		clientSocket = new Socket("localhost",8888);
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		String inputLine;
		while( (inputLine = stdIn.readLine()) != null ) {
			out.println(inputLine+"[client]");
			System.out.println("server로부터 다시 받은 메시지: " + in.readLine());
		}
		
		stdIn.close();
		in.close();
		out.close();
		clientSocket.close();
		
	}
}
