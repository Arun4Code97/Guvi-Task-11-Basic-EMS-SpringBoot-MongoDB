package com.arun.projects.SpringMVC_MongoDB_EMS.Exception;

import com.arun.projects.SpringMVC_MongoDB_EMS.Data.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeIdExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerMethodForEmployeeIdAlreadyExist(EmployeeIdExistException ex)
    {
        return new ErrorResponse("409- Conflict  ", ex.getMessage());
    }
    @ExceptionHandler(EmployeeIdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerMethodForEmployeeIdNotFoundException(EmployeeIdNotFoundException ex)
    {
        return new ErrorResponse("404 - Resource not found ", ex.getMessage());
    }

    @ExceptionHandler(NoEmployeesFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ErrorResponse handlerMethodForNoEmployeesFoundException(NoEmployeesFoundException ex){
        return new ErrorResponse("404 - Resource not found", ex.getMessage() );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> validationErrors = new HashMap<>();
            ex.getBindingResult().getFieldErrors()
                .forEach( error -> validationErrors.put(
                              error.getField()
                            , error.getDefaultMessage())
                        );
        return new ErrorResponse("400 - Bad Request : Validation failed",validationErrors);
    }
}
