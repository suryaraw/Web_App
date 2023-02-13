package com.black.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterndLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/suryadb", "root",
					"$ury@301299lMY");
			PreparedStatement ps = con.prepareStatement("insert into suryadb.new values(?,?)");
			ps.setString(1, mail);
			ps.setString(2, pass);
			int a = ps.executeUpdate();
			System.out.println(a + " : inserted ");

			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
