package org.jsp.products.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
//error handling
@RestControllerAdvice
public class ProductExceptionHandler {

	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> handle(){
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("error", "correctly type the url");
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handle1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "Enter Proper Value in the Path");
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
