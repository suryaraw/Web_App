package com.black.SpringJdbcConnector1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jdbc")
public class JDBC  {
	Connection con;
	@Value("${Scheme.driver}")
	private String driver;
	@Value("${Scheme.url}")
	private String url;
	@Value("${Scheme.user}")
	private String user;
	@Value("${Scheme.password}")
	private String password;
	@Value("${Scheme.query}")
	private String query;
	
	

	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
	void display() {
		

		System.out.println(" URL      : "+url+"\n USER     : "+ user+"\n PASSWORD : "+ password+"\n QUERY    : "+query);
	}
	
	void insertValues() {
		
		
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		
		System.out.print("Id : ");
		String id = cin.nextLine();
		System.out.print("Name : ");
		String name= cin.nextLine();
		System.out.print("Domain : ");
		String domain= cin.nextLine();
		
		
		try {
			GetConnection get = new GetConnection();
			get.getConnection(driver,url,user, password);
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, domain);
			int alert=ps.executeUpdate();		
			System.out.println(alert + ", file executed..");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
