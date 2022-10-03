package details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_Details")

public class StudentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Student_Name")
	private String StudentName;
	
	@Column(name="Roll_No")
	private String RollNo;
	
	@Column(name="Class")
	private String StudentClass;

	public StudentDetails() {
		
	}
	
	public StudentDetails(String studentName, String rollNo, String studentClass) {
		super();
		StudentName = studentName;
		RollNo = rollNo;
		StudentClass = studentClass;
	}


	public StudentDetails(int id, String studentName, String rollNo, String studentClass) {
		super();
		Id = id;
		StudentName = studentName;
		RollNo = rollNo;
		StudentClass = studentClass;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getStudentClass() {
		return StudentClass;
	}

	public void setStudentClass(String studentClass) {
		StudentClass = studentClass;
	}

	@Override
	public String toString() {
		return "StudentDetails [Id=" + Id + ", StudentName=" + StudentName + ", RollNo=" + RollNo + ", StudentClass="
				+ StudentClass + "]";
	}
	
	
}
