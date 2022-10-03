package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Util {

	private SessionFactory factory;
	
	public SessionFactory createConnection() {
		
		factory=new AnnotationConfiguration()
				.addPackage("details")
				.addAnnotatedClass(details.ClassDetails.class)
				.addAnnotatedClass(details.SubjectDetails.class)
				.addAnnotatedClass(details.StudentDetails.class)
				.addAnnotatedClass(details.TeacherDetails.class)
				.configure()
				.buildSessionFactory();
		
		return factory;
	}
	
}
