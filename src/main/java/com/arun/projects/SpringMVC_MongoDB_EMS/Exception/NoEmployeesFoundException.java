package com.arun.projects.SpringMVC_MongoDB_EMS.Exception;

public class NoEmployeesFoundException extends RuntimeException{
    public NoEmployeesFoundException(String message) {
        super(message);
    }
}
