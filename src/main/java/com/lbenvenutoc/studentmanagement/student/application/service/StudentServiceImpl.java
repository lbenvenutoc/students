package com.lbenvenutoc.studentmanagement.student.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbenvenutoc.studentmanagement.student.adapter.out.persistence.StudentJpaEntity;
import com.lbenvenutoc.studentmanagement.student.adapter.out.persistence.StudentMapper;
import com.lbenvenutoc.studentmanagement.student.application.port.in.StudentServicePort;
import com.lbenvenutoc.studentmanagement.student.application.port.out.StudentPersistencePort;
import com.lbenvenutoc.studentmanagement.student.application.service.constants.ErrorConstants;
import com.lbenvenutoc.studentmanagement.student.application.service.constants.StudentConstants;
import com.lbenvenutoc.studentmanagement.student.application.service.customexception.StudentExistsException;
import com.lbenvenutoc.studentmanagement.student.domain.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentServicePort {

	private StudentPersistencePort studentPersistencePort;

	@Autowired
	public StudentServiceImpl(StudentPersistencePort studentPersistencePort) {
		this.studentPersistencePort = studentPersistencePort;
	}

	@Override
	public Mono<Student> save(Student student) {
		StudentJpaEntity studentJpaEntity = StudentMapper.mapToStudentToStudentJpaEntity(student);
		return studentPersistencePort.findByCode(studentJpaEntity.getCode())
				.flatMap(studentInsideDataFlow -> Mono.<StudentJpaEntity>error(new StudentExistsException(
						ErrorConstants.MESSAGE_STUDENT_EXISTS + studentInsideDataFlow.getCode())))
				.switchIfEmpty(studentPersistencePort.save(studentJpaEntity)).flatMap(studentInsideDataFlow -> Mono
						.just(StudentMapper.mapStudentJpaEntityToStudent(studentInsideDataFlow)));

	}

	@Override
	public Flux<Student> listActive() {
		return studentPersistencePort.findByState(StudentConstants.ACTIVE_STATE)
				.map(studentJpaEntity -> StudentMapper.mapStudentJpaEntityToStudent(studentJpaEntity));
	}

}
