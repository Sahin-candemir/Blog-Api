package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
@Getter
//Yontem veya istisna sinifimizi işaretler İşleyici yöntemi çağrıldığında veya belirtilen istisna atıldığında durum kodu HTTP yanıtına uygulanır. ResponseEntityveya gibi başka yollarla ayarlanan durum bilgilerini geçersiz kılar
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	
	private String fieldName;
	
	private Long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		                    //Post not found with id : 1
		super(String.format("%s not found with %s : '%s'",resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
