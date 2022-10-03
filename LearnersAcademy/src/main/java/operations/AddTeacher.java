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

import details.TeacherDetails;
import util.Util;

@WebServlet("/teacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-teacher.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String teacherName= request.getParameter("TeacherName");
		String teacherSubject= request.getParameter("Subject");
		String teacherClass=request.getParameter("TeacherClass");
		
		try {
			
			Util u= new Util();
			
			SessionFactory factory=u.createConnection();
			
			Session session=factory.openSession();
			
			TeacherDetails teacherDetails=new TeacherDetails(teacherName, teacherSubject, teacherClass);
			
			Transaction tx=session.beginTransaction();
			
			session.save(teacherDetails);
			
			tx.commit();
			
			if(session!=null)
			{
				out.println("<div align='center'> <h2  style='color:green'> Teacher Details Added Successfully </h2>"
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
