package br.com.lukemedrano.SpringBootJPA.excecoes;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public static ResponseEntity<?> handleBadRequest() {
	    return ResponseEntity.badRequest().build();
	}
    
    @ExceptionHandler(NotFoundException.class)
    public static ResponseEntity<?> handleNotFound() {
    	return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(Exception.class)
    public static ResponseEntity<?> handleInternalServerError() {
        return ResponseEntity.internalServerError().build();
    }
}