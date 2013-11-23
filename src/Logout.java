import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			HttpSession session = req.getSession();
			session.invalidate();
			out.println("<div style'float:left;font-size:25px;'>Click here to <a href='Login.jsp'>Login</a></div>");
			out.println("<h1 align='center'>Logout Successfully</h1>");
			
		} catch(Exception e) {
			out.println("Something went to shit");
			out.println(e.toString());
		} finally {
			out.close();
		}
		
	}
	
}
