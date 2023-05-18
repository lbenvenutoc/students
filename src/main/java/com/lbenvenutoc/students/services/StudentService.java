package com.lbenvenutoc.students.services;

import com.lbenvenutoc.students.models.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {	

	public Mono<Student> save(Student student);

	public Flux<Student> listActive();

}
