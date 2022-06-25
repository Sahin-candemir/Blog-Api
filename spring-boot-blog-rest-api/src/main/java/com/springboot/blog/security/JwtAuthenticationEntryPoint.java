package com.springboot.blog.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*bir kimlik doğrulama başarrısız oldugunda çağrılır 
 * ve 401 (unauthorized) döner
 * mesaj ile beraber
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{ 
  /*Bu yöntem, kimliği doğrulanmamış bir kullanıcının kimlik doğrulama gerektiren
   *  bir kaynağa erişmeye çalışması nedeniyle bir istisna atıldığında çağrılır.
   */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,   
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}
	
	/*
	 * Development JWT process
	 * 1.adding JWT dependency
	 * 2.create JwtAuthenticationEntryPoint
	 * 3.add jwt properties in application.properties file
	 * 4.create jwtTokenprovider ---tokensağlayıcı
	 * 5.jwtAuthenticationFilter
	 * 6.create JWTAuthResponse DTO
	 * 7.configure jwt in spring security configuration
	 * 8.change login/signin API to return token to client
	 */

	
}
