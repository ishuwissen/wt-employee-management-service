package com.wissen.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Employee with that id not found");
    }
}
