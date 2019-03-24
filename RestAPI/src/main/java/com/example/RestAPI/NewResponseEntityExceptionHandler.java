package com.example.RestAPI;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Controller Advice because we want to share this exception
//across all controllers.i.e. for sharing across controllers we use
//@ControllerAdvice.
@ControllerAdvice
@RestController
public class NewResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		UserException userException = new UserException
				(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(userException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		UserException userException = new UserException
				(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(userException, HttpStatus.NOT_FOUND);
	}
}
