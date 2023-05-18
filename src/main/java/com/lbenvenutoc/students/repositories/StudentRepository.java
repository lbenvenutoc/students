package com.lbenvenutoc.students.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.lbenvenutoc.students.models.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends R2dbcRepository<Student, Long> {

	public Mono<Student> findByCode(Long code);

	public Flux<Student> findByState(Integer state);
}
