package app.pojo;

//import java.sql.Date;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "student_table")
public class Student {
	@Id
	@Column(name = "roll_no")
	int rollNo;
	@Column(name = "first_name", nullable = false)
	String firstName;
	@Basic
	@Column(name = "last_name")
	String lastName;
	
	Date date;
	
	public Student() {
	
	}
	
	public Student(int rollNo, String firstName, String lastName,Date d) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = d;
	}
	public void setDate(java.util.Date date2) {
		this.date = (Date) date2;
	}
	public Date getDate() {
		return this.date;
	}

	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName + ", Date="+date+"]";
	}


}
