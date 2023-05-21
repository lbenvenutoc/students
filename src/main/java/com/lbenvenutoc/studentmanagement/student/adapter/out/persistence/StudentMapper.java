package com.lbenvenutoc.studentmanagement.student.adapter.out.persistence;

import com.lbenvenutoc.studentmanagement.student.domain.Student;

public final class StudentMapper {

	public static Student mapStudentJpaEntityToStudent(StudentJpaEntity studentJpaEntity) {
		Student student = new Student();
		student.setAge(studentJpaEntity.getAge());
		student.setCode(studentJpaEntity.getCode());
		student.setId(studentJpaEntity.getId());
		student.setLastname(studentJpaEntity.getLastname());
		student.setName(studentJpaEntity.getName());
		student.setState(studentJpaEntity.getState());
		return student;
	}

	public static StudentJpaEntity mapToStudentToStudentJpaEntity(Student student) {
		StudentJpaEntity studentJpaEntity = new StudentJpaEntity();
		studentJpaEntity.setAge(student.getAge());
		studentJpaEntity.setCode(student.getCode());
		studentJpaEntity.setId(student.getId());
		studentJpaEntity.setLastname(student.getLastname());
		studentJpaEntity.setName(student.getName());
		studentJpaEntity.setState(student.getState());
		return studentJpaEntity;
	}

}
