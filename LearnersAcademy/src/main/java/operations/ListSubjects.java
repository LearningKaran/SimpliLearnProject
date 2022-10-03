package operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import details.SubjectDetails;
import util.Util;

@WebServlet("/listsubjects")
public class ListSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			
			Util u=new Util();
			
			SessionFactory factory = u.createConnection();
			
			Session session = factory.openSession();
			
			List<SubjectDetails> list = session.createQuery("from Subject_Details").list();
			
			out.println("<h2>Subject List");
			
			out.println("<style> table,td,th{"
					+ "border:2px solid red; "
					+ "padding:2px;}"
					+ "</style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>S.No</th>");
			out.println("<th>Subject Name</th>");
			out.println("<th>Subject Code</th>");
			out.println("<th>Subject Teacher</th>");
			out.println("<tr>");
			
			for(SubjectDetails subd : list) {
				out.println("<tr>");
				out.println("<td>"+ subd.getId() +"</td>");
				out.println("<td>"+ subd.getSubjectName() +"</td>");
				out.println("<td>"+ subd.getSubjectCode()+"</td>");
				out.println("<td>"+ subd.getSubjectTeacher() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='admin-page.html'>Back To MainMenu</a>");
			session.close();
			
		} 
		catch (Exception e) {
			out.println("<h2 style='color:red'>Operation Failed<h2>");
			out.println("<a href='admin-page.html'>Back To MainMenu</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
