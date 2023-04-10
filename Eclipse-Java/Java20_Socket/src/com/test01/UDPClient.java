package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("클라이언트");
		
		//받을 방 생성
		byte[] buff = new byte[1024];
		
		//패킷 받음
		DatagramPacket recieveP = new DatagramPacket(buff, buff.length);
		ds.receive(recieveP);
		
		System.out.println(new String(recieveP.getData()));
		
		//종료
		ds.close();
		ds.disconnect();
		
		
		
		
		
		
		
	}

}
