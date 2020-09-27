package com.datamodel.test;

public class StudentDetails {
	private String studentAddress;
	private String studentEmailAddress;
	private long studentMobileNumber;
	
	public StudentDetails(String studentAddress, String studentEmailAddress, long studentMobileNumber) {
		super();
		this.studentAddress = studentAddress;
		this.studentEmailAddress = studentEmailAddress;
		this.studentMobileNumber = studentMobileNumber;
	}
	
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentEmailAddress() {
		return studentEmailAddress;
	}
	public void setStudentEmailAddress(String studentEmailAddress) {
		this.studentEmailAddress = studentEmailAddress;
	}
	public long getStudentMobileNumber() {
		return studentMobileNumber;
	}
	public void setStudentMobileNumber(long studentMobileNumber) {
		this.studentMobileNumber = studentMobileNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentAddress == null) ? 0 : studentAddress.hashCode());
		result = prime * result + ((studentEmailAddress == null) ? 0 : studentEmailAddress.hashCode());
		result = prime * result + (int) (studentMobileNumber ^ (studentMobileNumber >>> 32));
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
		StudentDetails other = (StudentDetails) obj;
		if (studentAddress == null) {
			if (other.studentAddress != null)
				return false;
		} else if (!studentAddress.equals(other.studentAddress))
			return false;
		if (studentEmailAddress == null) {
			if (other.studentEmailAddress != null)
				return false;
		} else if (!studentEmailAddress.equals(other.studentEmailAddress))
			return false;
		if (studentMobileNumber != other.studentMobileNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentAddress=" + studentAddress + ", studentEmailAddress=" + studentEmailAddress
				+ ", studentMobileNumber=" + studentMobileNumber + "]";
	}
}
