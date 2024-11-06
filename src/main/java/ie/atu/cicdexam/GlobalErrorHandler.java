package ie.atu.cicdexam;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalErrorHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotFoundException.class)
    public ResponseEntity<Map<String,String>> showErrors(MethodArgumentNotValidException ex){
        Map<String,String> errorList1 = new HashMap<>();
        for(FieldError error:ex.getFieldErrors()){
            String err_name= error.getField();
            String err_message = error.getDefaultMessage();
            errorList1.put(err_name, err_message);
        }
        return ResponseEntity.status(400).body(errorList1);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> showErrors(EmployeeNotFoundException ex){
        Map<String,String> errorList2 = new HashMap<>();
        for(FieldError error:ex.getFieldErrors()){
            String err_name= error.getField();
            String err_message = error.getDefaultMessage();
            errorList2.put(err_name, err_message);
        }
        return ResponseEntity.status(400).body(errorList2);
    }

    @ExceptionHandler(InvalidEmployeeDataException.class)
    public ResponseEntity<Map<String,String>> showErrors(InvalidEmployeeDataException ex){
        Map<String,String> errorList3 = new HashMap<>();
        for(FieldError error:ex.getFieldErrors()){
            String err_name= error.getField();
            String err_message = error.getDefaultMessage();
            errorList3.put(err_name, err_message);
        }
        return ResponseEntity.status(400).body(errorList3);
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<Map<String,String>> showErrors(DuplicateEmailException ex){
        Map<String,String> errorList4 = new HashMap<>();
        for(FieldError error:ex.getFieldErrors()){
            String err_name= error.getField();
            String err_message = error.getDefaultMessage();
            errorList4.put(err_name, err_message);
        }
        return ResponseEntity.status(400).body(errorList4);
    }
}
