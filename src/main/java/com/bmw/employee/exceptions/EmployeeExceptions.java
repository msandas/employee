package com.bmw.employee.exceptions;

public class EmployeeExceptions {

    public static class EmployeeNotFound extends RuntimeException{
        public EmployeeNotFound(int id){
            super("Could not find employee with id "+id);
        }
    }

    public static class InvalidRequest extends RuntimeException{
        public InvalidRequest(String value){
            super("Request sent is invalid "+value);
        }
    }

    public static class ExecutionException extends RuntimeException{
        ExecutionException(String value){
            super("We could not execute requested operation. We are investigating... "+value);
        }
    }

}
