package com.black.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WebApp {
	@RequestMapping(value = "/home")
	public String menu() {
		
		return "home";
	}
}

package com.black.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String first = request.getParameter("firstname");
		String mid = request.getParameter("middlename");
		String last = request.getParameter("lastname");
		String ph = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("repass");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "$ury@301299lMY");
			PreparedStatement ps = cn.prepareStatement("insert into admin.emp1 values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, first);
			ps.setString(2, mid);
			ps.setString(4, last);
			ps.setString(5, ph);
			ps.setString(6, address);
			ps.setString(7, email);
			ps.setString(8, pass);
			ps.setString(9, rpass);

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "$ury@301299lMY");
			PreparedStatement ps = cn.prepareStatement("select * from admin.emp1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8)
						+ " " + rs.getString(9));
			}
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}