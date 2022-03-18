package br.com.apiclient.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.apiclient.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception,
			HttpServletRequest httpServletRequest) {
		StandardError standardError = new StandardError();
		standardError.setError("Resource Not Found");
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(HttpStatus.NOT_FOUND.value());
		standardError.setMessage(exception.getMessage());
		standardError.setPath(httpServletRequest.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}

}
