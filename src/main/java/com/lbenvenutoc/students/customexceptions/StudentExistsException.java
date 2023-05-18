package com.lbenvenutoc.students.customexceptions;

public class StudentExistsException extends Exception {

	private static final long serialVersionUID = 5490047625141395752L;

	public StudentExistsException(String messaje) {
		super(messaje);
	}

}
