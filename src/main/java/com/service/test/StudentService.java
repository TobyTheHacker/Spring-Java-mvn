package com.service.test;

import java.util.Collection;

import com.datamodel.test.Student;

/**
 * @author shobhit
 *
 */
public interface StudentService {
	
	//put the student object in to the DB
	public void putStudent(Student student);
	
	//put the collection of all the student object in to the DB
	public void putStudent(Collection<Student> student, boolean value);
	
	//get student object from the DB 
	public Student getStudent(int rollNo);
	
	//get the collection of all the student available
	public Collection<Student> getAllStudent();
}
