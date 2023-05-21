package com.lbenvenutoc.studentmanagement.student.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student implements Serializable {

	@JsonIgnore
	private Long id;

	@NotNull(message = "code cannot be null")
	private Long code;

	@NotNull(message = "name cannot be null")
	private String name;

	@NotNull(message = "lastname cannot be null")
	private String lastname;

	@NotNull(message = "state cannot be null")
	private Integer state;

	@NotNull(message = "age cannot be null")
	private Integer age;

	private static final long serialVersionUID = -5169328850374301499L;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
