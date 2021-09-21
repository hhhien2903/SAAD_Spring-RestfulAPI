package error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring.model.ErrorMessage;

@RestControllerAdvice
public class RestResponeEntityExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage> EmployeeNotFoundException(
			EmployeeNotFoundException exception) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST,
				exception.getMessage());

		// ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
		// exception.getMessage());
		// if you want to get status code
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}

}
