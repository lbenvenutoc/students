package com.lbenvenutoc.students.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.lbenvenutoc.students.customexceptions.StudentExistsException;
import com.lbenvenutoc.students.models.Student;
import com.lbenvenutoc.students.services.StudentService;
import com.lbenvenutoc.students.services.constants.ErrorConstants;
import com.lbenvenutoc.students.testutils.GenerateStudentsObjectTestUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private StudentService studentService;

	@Test
	public void givenStudentWhenSaveStudentThenReturnSavedStudent() {

		Student student = GenerateStudentsObjectTestUtil.getFirstStudent();

		given(studentService.save(any(Student.class))).willReturn(Mono.just(student));

		WebTestClient.ResponseSpec response = webTestClient.post().uri("/api/students")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(student), Student.class).exchange();

		response.expectStatus().isCreated().expectBody().jsonPath("$.name").isEqualTo(student.getName());
	}

	@Test
	public void givenWrongStudentWhenSaveStudentThenReturnBadRequest() {

		Student student = GenerateStudentsObjectTestUtil.getWrongFirstStudent();

		given(studentService.save(student)).willReturn(Mono
				.<Student>error(new StudentExistsException(ErrorConstants.MESSAGE_STUDENT_EXISTS + student.getCode())));

		WebTestClient.ResponseSpec response = webTestClient.post().uri("/api/students")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).exchange();

		response.expectStatus().isBadRequest();
	}

	@Test
	public void givenActiveStateWhenFindByStateThenReturnStudentList() {

		given(studentService.listActive()).willReturn(Flux.just(GenerateStudentsObjectTestUtil.getFirstStudent()));

		WebTestClient.ResponseSpec response = webTestClient.get().uri("/api/students").exchange();

		response.expectStatus().isOk();
	}

}
