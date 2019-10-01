package com.jy.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnector {

	// 메서드명이 getConnect

	public static Connection getConnect() throws Exception {

		String user = "scott";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con= DriverManager.getConnection(url, user, pw);
		
		
		return con;
	}

}
