package com.black.SpringJdbcConnector1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	void getConnection(String driver,String url,String user, String password)  {
		
		@SuppressWarnings("unused")
		Connection con ;
		try {
			Class.forName(driver);
			 con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
