package com.datamodel.test;

public class Student {
	private int studentRollNumber;
	private String studentFirstName;
	private String studentLastName;
	private int studentAge;
	private StudentDetails studentDetails;
	
	public Student(int studentRollNumber, String studentFirstName, String studentLastName, int studentAge,
			StudentDetails studentDetails) {
		super();
		this.studentRollNumber = studentRollNumber;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAge = studentAge;
		this.studentDetails = studentDetails;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentAge;
		result = prime * result + ((studentDetails == null) ? 0 : studentDetails.hashCode());
		result = prime * result + ((studentFirstName == null) ? 0 : studentFirstName.hashCode());
		result = prime * result + ((studentLastName == null) ? 0 : studentLastName.hashCode());
		result = prime * result + studentRollNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentAge != other.studentAge)
			return false;
		if (studentDetails == null) {
			if (other.studentDetails != null)
				return false;
		} else if (!studentDetails.equals(other.studentDetails))
			return false;
		if (studentFirstName == null) {
			if (other.studentFirstName != null)
				return false;
		} else if (!studentFirstName.equals(other.studentFirstName))
			return false;
		if (studentLastName == null) {
			if (other.studentLastName != null)
				return false;
		} else if (!studentLastName.equals(other.studentLastName))
			return false;
		if (studentRollNumber != other.studentRollNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentRollNumber=" + studentRollNumber + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", studentAge=" + studentAge + ", studentDetails="
				+ studentDetails + "]";
	}
}

class StudentBuilder{
	private int studentRollNumber;
	private String studentFirstName;
	private String studentLastName;
	private int studentAge;
	private StudentDetails studentDetails;
	
	public StudentBuilder setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
		return this;
	}
	public StudentBuilder setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
		return this;
	}
	public StudentBuilder setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
		return this;
	}
	public StudentBuilder setStudentAge(int studentAge) {
		this.studentAge = studentAge;
		return this;
	}
	public StudentBuilder setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
		return this;
	}
	
	public Student getStudent() {
		return new Student(studentRollNumber, studentFirstName, studentLastName, studentAge, studentDetails);
	}
}