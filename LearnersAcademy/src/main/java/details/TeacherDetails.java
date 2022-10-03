package details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_Details")
public class TeacherDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Teacher_Name")
	private String TeacherName;
	
	@Column(name="Subject")
	private String Subject;
	
	@Column(name="Class")
	private String TeacherClass;

	public TeacherDetails() {
	
	}

	public TeacherDetails(int id, String teacherName, String subject, String teacherClass) {
		super();
		Id = id;
		TeacherName = teacherName;
		Subject = subject;
		TeacherClass = teacherClass;
	}

	public TeacherDetails(String teacherName, String subject, String teacherClass) {
		super();
		TeacherName = teacherName;
		Subject = subject;
		TeacherClass = teacherClass;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getTeacherClass() {
		return TeacherClass;
	}

	public void setTeacherClass(String teacherClass) {
		TeacherClass = teacherClass;
	}

	@Override
	public String toString() {
		return "TeacherDetails [Id=" + Id + ", TeacherName=" + TeacherName + ", Subject=" + Subject + ", TeacherClass="
				+ TeacherClass + "]";
	}

}
