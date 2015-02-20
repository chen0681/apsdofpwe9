package com.free.testspring;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTest {

	public void testGetMetadata() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/YTDB", "root", "root");
		
		DatabaseMetaData metadata = conn.getMetaData();
		
		ResultSet tableRet = metadata.getTables(null, "%", "%", new String[]{"TABLE"});

//		while(tableRet.next()) {
//			tableRet.getc
//		}
	}
}
