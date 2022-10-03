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

import details.ClassDetails;
import util.Util;


@WebServlet("/class")
public class AddClass extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("add-class.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String className=request.getParameter("ClassName");
		String classSection=request.getParameter("ClassSection");
		String classRoomNo=request.getParameter("ClassRoomNo");
		
	try {
			
		Util u= new Util();
		
		SessionFactory factory=u.createConnection();
		
		Session session= factory.openSession();
		
		ClassDetails classDetails=new ClassDetails(className, classSection, classRoomNo);
		
		Transaction tx = session.beginTransaction();
		
		session.save(classDetails);
		
		tx.commit();
		
		if(session!=null)
		{
			out.println("<div align='center'><h2 style='color:green'>Class Added Successfully</h2>"
					+ "<a href='admin-page.html'>Back To MainMenu</a>"
					+ "</div>");
		}
		session.close();

	}
	catch (Exception e) {
			out.println("<div align='center'><h2 style='color:red'>Operation Failed</h2>"
					+ "<a href='admin-page.html'>Back To MainMenu</a>"
					+ "</div>");
		}

	}
}
