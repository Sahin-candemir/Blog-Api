package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;


import lombok.Getter;

@Getter
public class BlogAPIException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;
	
	public BlogAPIException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	
	
	
	
}
