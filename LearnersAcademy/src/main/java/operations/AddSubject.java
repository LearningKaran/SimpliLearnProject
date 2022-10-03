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

import details.SubjectDetails;
import util.Util;

@WebServlet("/subject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-subject.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String subjectName=request.getParameter("SubjectName");
		String subjectCode=request.getParameter("SubjectCode");
		String subjectTeacher= request.getParameter("SubjectTeacher");
		
		try {
			
			Util u=new Util();
			
			SessionFactory factory=u.createConnection();
			
			Session session=factory.openSession();
			
			SubjectDetails subjectDetails=new SubjectDetails(subjectName, subjectCode, subjectTeacher);
			
			Transaction tx= session.beginTransaction();
			
			session.save(subjectDetails);
			
			tx.commit();
			
			if(session!=null)
			{
				out.println("<div align='center'> <h2 style= 'color:green'>Subject Details Added Successfully</h2>"
						+ "<a href='admin-page.html'>Back to Main Menu</a>"
						+ "</div>");
			}
			session.close();
			
		}
		
		catch(Exception e)
		{
			out.println("<div align='center'> <h2 style='color:red'>Operation Failed</h2>"
					+ "<a href='admin-page.html'>Back to Main Menu</a>"
					+ "</div>");
		}
	}
}

