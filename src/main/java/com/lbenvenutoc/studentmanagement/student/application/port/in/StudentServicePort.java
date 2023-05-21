package com.lbenvenutoc.studentmanagement.student.application.port.in;

import com.lbenvenutoc.studentmanagement.student.domain.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentServicePort {

	public Mono<Student> save(Student student);

	public Flux<Student> listActive();

}
