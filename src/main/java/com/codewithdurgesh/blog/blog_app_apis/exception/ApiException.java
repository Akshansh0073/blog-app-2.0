package com.codewithdurgesh.blog.blog_app_apis.exception;

public class ApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ApiException() {
		super();
		
	}

	public ApiException(String message) {
		super(message);
		
	}

	
}
