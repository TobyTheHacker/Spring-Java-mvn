package com.service.impl.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedHashSet;

import com.datamodel.test.Student;
import com.datamodel.test.StudentDetails;
import com.service.test.StudentService;
import com.utils.StudentDataCreator;

/**
 * @author shobhit
 *
 */
public class StudentServiceImpl implements StudentService{

	@Override
	public void putStudent(Student student) {
		try {
			System.out.println("Started the connection");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "@dmin1");
			// here db1 is database name, username and password
			System.out.println("Connected to db");
			
			// here we'll check if the table exist
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "Students", null);
			
			if (tables.next()) {
			  // Table exists
				System.out.println("Table exists, updating the value/s");
				Statement statement = con.createStatement();
				statement.execute("INSERT INTO Students ("
						+ " Student_ID, Student_FirstName, Student_LastName, "
						+ "Student_Age, Student_Address, Student_EmailAddress, "
						+ "Student_MobileNumber"
						+ ")" +
				        " VALUES ("
				        + ""+student.getStudentRollNumber()+", "+"'"+student.getStudentFirstName()+"', "+"'"+student.getStudentLastName()+"', "
				        + ""+student.getStudentAge()+", "+"'"+student.getStudentDetails().getStudentAddress()+"', "+"'"+student.getStudentDetails().getStudentEmailAddress()+"', "
				        + ""+student.getStudentDetails().getStudentMobileNumber()
				        + ")");
				System.out.println("Table got updated");
			} else {
			  // Table does not exist, create new one, only for first timer purpose
				System.out.println("Table don't exists, create new one, then updating the value/s");
				
				Statement statement = con.createStatement();
				statement.execute("create table Students ("
						+ " Student_ID int, "
						+ "Student_FirstName varchar(255), "
						+ "Student_LastName varchar(255), "
						+ "Student_Age int, "
						+ "Student_Address varchar(510), "
						+ "Student_EmailAddress varchar(510), "
						+ "Student_MobileNumber bigint"
						+ ");");
				System.out.println("Table got created, now updating value/s...");
				
				statement.execute("INSERT INTO Students ("
						+ " Student_ID, Student_FirstName, Student_LastName, "
						+ "Student_Age, Student_Address, Student_EmailAddress, "
						+ "Student_MobileNumber"
						+ ")" +
				        " VALUES ("
				        + ""+student.getStudentRollNumber()+", "+"'"+student.getStudentFirstName()+"', "+"'"+student.getStudentLastName()+"', "
				        + ""+student.getStudentAge()+", "+"'"+student.getStudentDetails().getStudentAddress()+"', "+"'"+student.getStudentDetails().getStudentEmailAddress()+"', "
				        + ""+student.getStudentDetails().getStudentMobileNumber()
				        + ")");
				System.out.println("Table got updated");
			}
			
			//Need to know the list of tables available in DB
			/*
			 * ResultSet tablesList = dbm.getTables(null, null, "%", null); while
			 * (tablesList.next()) { System.out.println(tablesList.getString(3)); }
			 */
			
			con.close();
			System.out.println("Completed the transaction");
		} catch (Exception e) {
			System.out.println("Error while completing the transaction");
			e.printStackTrace();
		}
	}

	@Override
	public void putStudent(Collection<Student> studentList, boolean value) {
		try {
			System.out.println("Started the connection");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "@dmin1");
			// here db1 is database name, username and password
			System.out.println("Connected to db");
			
			//If you wish to delete older table from db then go for this
			if(value) {
				Statement statement = con.createStatement();
				statement.execute("drop table Students");
				System.out.println("Deleted existing table");
			}
			
			// here we'll check if the table exist
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, "Students", null);
			
			if (tables.next()) {
			  // Table exists
				System.out.println("Table exists, updating the value/s");
				for(Student student : studentList) {
					Statement statement = con.createStatement();
					statement.execute("INSERT INTO Students ("
							+ " Student_ID, Student_FirstName, Student_LastName, "
							+ "Student_Age, Student_Address, Student_EmailAddress, "
							+ "Student_MobileNumber"
							+ ")" +
					        " VALUES ("
					        + ""+student.getStudentRollNumber()+", "+"'"+student.getStudentFirstName()+"', "+"'"+student.getStudentLastName()+"', "
					        + ""+student.getStudentAge()+", "+"'"+student.getStudentDetails().getStudentAddress()+"', "+"'"+student.getStudentDetails().getStudentEmailAddress()+"', "
					        + ""+student.getStudentDetails().getStudentMobileNumber()
					        + ")");
				}
				System.out.println("Table got updated");
			} else {
			  // Table does not exist, create new one, only for first timer purpose
				System.out.println("Table don't exists, create new one, then updating the value/s");
				Statement statement = con.createStatement();
				statement.execute("create table Students ("
						+ " Student_ID int, "
						+ "Student_FirstName varchar(255), "
						+ "Student_LastName varchar(255), "
						+ "Student_Age int, "
						+ "Student_Address varchar(510), "
						+ "Student_EmailAddress varchar(510), "
						+ "Student_MobileNumber bigint"
						+ ");");
				System.out.println("Table got created, now updating value/s...");
				for(Student student : studentList) {
					statement.execute("INSERT INTO Students ("
							+ " Student_ID, Student_FirstName, Student_LastName, "
							+ "Student_Age, Student_Address, Student_EmailAddress, "
							+ "Student_MobileNumber"
							+ ")" +
					        " VALUES ("
					        + ""+student.getStudentRollNumber()+", "+"'"+student.getStudentFirstName()+"', "+"'"+student.getStudentLastName()+"', "
					        + ""+student.getStudentAge()+", "+"'"+student.getStudentDetails().getStudentAddress()+"', "+"'"+student.getStudentDetails().getStudentEmailAddress()+"', "
					        + ""+student.getStudentDetails().getStudentMobileNumber()
					        + ")");
				}
				System.out.println("Table got updated with "+studentList.size()+" records");
			}
			
			//Need to know the list of tables available in DB
			/*
			 * ResultSet tablesList = dbm.getTables(null, null, "%", null); while
			 * (tablesList.next()) { System.out.println(tablesList.getString(3)); }
			 */
			
			con.close();
			System.out.println("Completed the transaction");
		} catch (Exception e) {
			System.out.println("Error while completing the transaction");
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int value) {
		Student student = null;
		try {
			System.out.println("Started the connection");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "@dmin1");
			// here db1 is database name, username and password
			System.out.println("Connected to db");
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from Students where Student_ID = "+value);
			
			while (rs.next())
				student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new StudentDetails(rs.getString(5), rs.getString(6), rs.getLong(7)));
			
			con.close();
			System.out.println("Completed the transaction");
		} catch (Exception e) {
			System.out.println("Error while completing the transaction");
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public Collection<Student> getAllStudent() {
		LinkedHashSet<Student> studentList = null;
		try {
			System.out.println("Started the connection");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "@dmin1");
			// here db1 is database name, username and password
			System.out.println("Connected to db");
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from Students");
			
			studentList = new LinkedHashSet<>();
			while (rs.next()) {
				studentList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), new StudentDetails(rs.getString(5), rs.getString(6), rs.getLong(7))));
			}
			
			con.close();
			System.out.println("Completed the transaction");
		} catch (Exception e) {
			System.out.println("Error while completing the transaction");
			e.printStackTrace();
		}
		return studentList;
	}
	
	public static void main(String[] args) {
		StudentServiceImpl serviceImpl = new StudentServiceImpl();
		StudentDataCreator dataCreator = new StudentDataCreator();
		
		//serviceImpl.putStudent(new Student(11, null, null, 25, new StudentDetails(null, null, 0)));
		
		//System.out.println(serviceImpl.getStudent(4));
		
		Collection<Student> list = dataCreator.create(10000);
		serviceImpl.putStudent(list, false);
		
		/*
		 * Collection<Student> list = serviceImpl.getAllStudent(); for(Student student :
		 * list) { System.out.println(student); }
		 */
	}
	
}
