import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Validate")
public class Validate extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			String name = req.getParameter("uid");
			String pass = req.getParameter("pid");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginSystem?" + "user=root&password=root");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from login where username='"+name+"'");
			
			if(rs.next()) {
				if(name.trim().equals(rs.getString("username").trim()) && (pass.trim().equals(rs.getString("password").trim()))) {
					HttpSession session = req.getSession(true);
					session.setAttribute("user", name);
					RequestDispatcher view = req.getRequestDispatcher("Welcome.jsp");
					view.forward(req, resp);
				} else {
					out.println("<div style='font-size: 30px; color: red'>" + "Userid and password does not match"+"</div>");
					RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
					view.include(req, resp);
				}
			} else {
				out.println("<div style='font-size: 30px; color: red'> Please fill userid and password </div>");
				RequestDispatcher view = req.getRequestDispatcher("Login.jsp");
				view.include(req, resp);
			}
		} catch (Exception e) {
			out.println("Something went to hell");
			out.println(e.toString());
		}
		finally{
			out.close();
		}
	}

}
