package com.arun.projects.SpringMVC_MongoDB_EMS.Exception;

public class EmployeeIdNotFoundException extends RuntimeException{
  public EmployeeIdNotFoundException(String message){
      super(message);
  }
}
