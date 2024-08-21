package com.arun.projects.SpringMVC_MongoDB_EMS.Exception;

public class EmployeeIdExistException extends RuntimeException{

    public EmployeeIdExistException(String message) {
        super(message);
    }
}
