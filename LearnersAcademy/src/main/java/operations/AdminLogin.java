package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("admin-login.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("adminemail");
		String password = request.getParameter("adminpassword");
		
		if(email.equals("") && password.equals("")) 
		{
			out.println("<div align='center'><h2 style='color:red'>Mandatory Fields Are Empty</h2>"
					+ "<a href='login'>Retry</a>"
					+ "</div>");
		}
		else {
				
			if(email.equals("admin@gmail.com") && password.equals("admin@123")) {
					out.println("<div align='center'><h2 style='color:green'>Welcome To Admin Portal</h2></div>");
					request.getRequestDispatcher("admin-page.html").include(request, response);
			}
			else {
					out.println("<div align='center'><h2 style='color:red'>Invalid Credentials</h2>"
							+ "<a href='login'>Retry</a>"
							+ "</div>");
			}
		}

	}
}
