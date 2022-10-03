package operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import details.StudentDetails;
import util.Util;

@WebServlet("/student")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.getRequestDispatcher("add-student.html").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	String studentName= request.getParameter("StudentName");
	String rollNo= request.getParameter("RollNo");
	String studentClass=request.getParameter("StudentClass");
	
	try {
		
		Util u= new Util();
		
		SessionFactory factory=u.createConnection();
		
		Session session=factory.openSession();
		
		StudentDetails studentDetails=new StudentDetails(studentName, rollNo, studentClass);
		
		Transaction tx=session.beginTransaction();
		
		session.save(studentDetails);
		
		tx.commit();
		
		if(session!=null)
		{
			out.println("<div align='center'> <h2  style='color:green'> Student Details Added Successfully </h2>"
					+ "<a href='admin-page.html'>Back to Main Menu</a>"
					+ "</div>");
		}
		
		session.close();
		
		}
		catch(Exception e){
			
			out.println("<div align='center'> <h2  style='color:red'> Operation Failed </h2>"
					+ "<a href='admin-page.html'>Back to Main Menu</a>"
					+ "</div>");	
		}
	}

}
