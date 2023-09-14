package com.bmw.employee.exceptions;

import com.bmw.employee.dto.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandleAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeExceptions.EmployeeNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    EmployeeErrorResponse employeeNotFound(EmployeeExceptions.EmployeeNotFound ex){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setMessage(ex.getMessage());
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setTimeStamp(Calendar.getInstance().getTimeInMillis());

        return employeeErrorResponse;

    }

    @ResponseBody
    @ExceptionHandler(EmployeeExceptions.InvalidRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    EmployeeErrorResponse invalidRequest(EmployeeExceptions.InvalidRequest ex){
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setMessage(ex.getMessage());
        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setTimeStamp(Calendar.getInstance().getTimeInMillis());

        return employeeErrorResponse;

    }
}
