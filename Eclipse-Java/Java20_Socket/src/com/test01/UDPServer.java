package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {
	public static void main(String[] args)throws IOException {
		//소켓 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("서버입니다.");
		
		//보낼 데이터
		byte[] buff = "연습입니다.".getBytes();
		
		//DatagramPacket
		DatagramPacket sendP = new DatagramPacket(buff,buff.length,InetAddress.getByName("localhost"),9999);
		
		//전송
		ds.send(sendP);
		
		//종료
		ds.close();
		ds.disconnect();
		
		
		
		
		
	}
}
