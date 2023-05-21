package com.lbenvenutoc.studentmanagement.student.adapter.in.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lbenvenutoc.studentmanagement.student.application.port.in.StudentServicePort;
import com.lbenvenutoc.studentmanagement.student.domain.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class StudentController {

	private StudentServicePort studentService;

	@Autowired
	public StudentController(StudentServicePort studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/students")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Student> create(@Valid @RequestBody Student student) {
		return studentService.save(student);
	}

	@GetMapping("/students")
	@ResponseStatus(HttpStatus.OK)
	public Flux<Student> listActiceStudents() {
		return studentService.listActive();
	}

}
