package com.wallace.spring.boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends DomainException {
	private static final long serialVersionUID = 1L;

	public PostNotFoundException(String msg) {
		super(msg);
	}

}
