package com.lbenvenutoc.students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbenvenutoc.students.customexceptions.StudentExistsException;
import com.lbenvenutoc.students.models.Student;
import com.lbenvenutoc.students.repositories.StudentRepository;
import com.lbenvenutoc.students.services.constants.ErrorConstants;
import com.lbenvenutoc.students.services.constants.StudentConstants;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Mono<Student> save(Student student) {

		return studentRepository.findByCode(student.getCode())
				.flatMap(studentInsideDataFlow -> Mono.<Student>error(new StudentExistsException(
						ErrorConstants.MESSAGE_STUDENT_EXISTS + studentInsideDataFlow.getCode())))
				.switchIfEmpty(studentRepository.save(student));

	}

	@Override
	public Flux<Student> listActive() {
		return studentRepository.findByState(StudentConstants.ACTIVE_STATE);
	}

}
