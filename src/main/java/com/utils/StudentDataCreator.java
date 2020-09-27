package com.utils;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;

import com.datamodel.test.Student;
import com.datamodel.test.StudentDetails;

public class StudentDataCreator {
	
	public Collection<Student> create(int value) {
		LinkedHashSet<Student> set = new LinkedHashSet<>();
		for(int i = 0; i < value; i++) {
			set.add(new Student((i+1), "FirstName"+(i+1), "LastName"+(i+1), new Random().nextInt(6)+20, new StudentDetails("Address"+(i+1), "student"+(i+1)+"@gmail.com", 9999900000l+(i+1))));
		}
		return set;
	}
	public static void main(String[] args) {
		StudentDataCreator sdc = new StudentDataCreator();
		Collection<Student> student = sdc.create(10000);
		for(Student s : student) {
			System.out.println(s);
		}
	}

}
