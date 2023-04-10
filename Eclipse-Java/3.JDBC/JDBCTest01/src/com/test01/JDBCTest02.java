package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {
	//Department테이블 select 해보자.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.
		Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/multi",
											"root",
											"rjsgh1078");
		
		//3.
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(" SELECT * FROM DEPARTMENT ");
		
		//4.
		while(rs.next()) {
			System.out.println(rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString("LOCATION_ID"));
		}
		
		//5. DB 종료
		rs.close();
		stmt.close();
		con.close();
		
		
		
		
		
	}

}
