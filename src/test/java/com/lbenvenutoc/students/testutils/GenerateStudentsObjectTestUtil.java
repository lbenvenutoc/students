package com.lbenvenutoc.students.testutils;

import com.lbenvenutoc.students.models.Student;

public final class GenerateStudentsObjectTestUtil {

	public static Student getFirstStudent() {
		Student student = new Student();
		student.setCode(1L);
		student.setId(1L);
		student.setAge(37);
		student.setName("Luis");
		student.setLastname("Benvenuto");
		student.setState(1);
		return student;
	}

	public static Student getSecondStudent() {
		Student student = new Student();
		student.setCode(2L);
		student.setId(2L);
		student.setAge(33);
		student.setName("Ana");
		student.setLastname("Tafur");
		student.setState(1);
		return student;
	}

	public static Student getWrongFirstStudent() {
		Student student = getFirstStudent();
		student.setName(null);
		return student;
	}

}
