package com.lbenvenutoc.studentmanagement.student.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends R2dbcRepository<StudentJpaEntity, Long> {

	public Mono<StudentJpaEntity> findByCode(Long code);

	public Flux<StudentJpaEntity> findByState(Integer state);
}
