package com.appointments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException
{
	@ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException e)
   {
	   String message=e.getMessage();
	   APIResponse response=new APIResponse(message,false);
	   return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
   }
}
