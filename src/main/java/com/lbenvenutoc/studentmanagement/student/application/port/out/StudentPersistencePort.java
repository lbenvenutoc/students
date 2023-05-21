package com.lbenvenutoc.studentmanagement.student.application.port.out;

import com.lbenvenutoc.studentmanagement.student.adapter.out.persistence.StudentJpaEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentPersistencePort {

	public Mono<StudentJpaEntity> save(StudentJpaEntity student);

	public Mono<StudentJpaEntity> findByCode(Long code);

	public Flux<StudentJpaEntity> findByState(Integer state);

}
