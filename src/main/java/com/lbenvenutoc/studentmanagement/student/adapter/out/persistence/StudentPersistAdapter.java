package com.lbenvenutoc.studentmanagement.student.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lbenvenutoc.studentmanagement.student.application.port.out.StudentPersistencePort;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class StudentPersistAdapter implements StudentPersistencePort {

	private StudentRepository studentRepository;

	@Autowired
	public StudentPersistAdapter(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Mono<StudentJpaEntity> save(StudentJpaEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public Mono<StudentJpaEntity> findByCode(Long code) {
		return studentRepository.findByCode(code);
	}

	@Override
	public Flux<StudentJpaEntity> findByState(Integer state) {
		return studentRepository.findByState(state);
	}

}
