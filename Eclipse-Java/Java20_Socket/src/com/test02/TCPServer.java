package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		//서버소켓 생성
		ServerSocket serverSocket = null;
		
		//요청한 클라이언트와 연결 소켓
		Socket serviceSocket = null;
		
		//출력객체
		PrintWriter out = null;
		//입력객체
		BufferedReader in = null;
		
		
		serverSocket = new ServerSocket(8888);
		
		System.out.println("client를 기다립니다.");
		
		while(true) {
			serviceSocket = serverSocket.accept();
			
			in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
			
			
			out = new PrintWriter(serviceSocket.getOutputStream(), true);
		
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				System.out.println("클라이언트가 보낸 메시지: " + inputLine);
				out.println(inputLine+"[server]");
			}
			out.close();
			in.close();
			serviceSocket.close();
			serverSocket.close();
		}
		
	}

}
