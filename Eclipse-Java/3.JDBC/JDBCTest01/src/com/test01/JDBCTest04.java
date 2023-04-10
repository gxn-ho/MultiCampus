package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import static common.JDBCTemplate.*;

public class JDBCTest04 {

	public static void main(String[] args) throws SQLException {
		//0.
		Connection con = null;
		PreparedStatement pstm = null;
		
		int res = 0;
		
		int no = 0;
		String name = null;
		String nickName = null;
		
		String sql = " INSERT INTO MYTEST VALUES(?,?,?) ";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("NO: ");
		no = sc.nextInt();
		System.out.print("NAME: ");
		name = sc.next();
		System.out.print("NICKNAME: ");
		nickName = sc.next();
		
		//
		
		con = getConnection();
		
		//
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no);
		pstm.setString(2, name);
		pstm.setString(3, nickName);
		
		res = pstm.executeUpdate();
		//
		if(res>0) {
			System.out.println("insert 성공");
			Commit(con);
		}else {
			System.out.println("insert 실패");
			Rollback(con);
		}
		
		//
		Close(pstm);
		Close(con);
		sc.close();
		
		
		
		
		
		
		
		
	}

	private static void Commit(Connection con) {
		// TODO Auto-generated method stub
		
	}

}
