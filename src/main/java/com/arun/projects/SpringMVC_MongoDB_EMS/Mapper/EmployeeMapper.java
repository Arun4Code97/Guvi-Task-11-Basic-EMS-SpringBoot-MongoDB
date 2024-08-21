package com.arun.projects.SpringMVC_MongoDB_EMS.Mapper;

import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import com.arun.projects.SpringMVC_MongoDB_EMS.Model.Employee;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDTO inputData){
        return new Employee(Integer.parseInt(inputData.getId()), inputData.getName(), inputData.getEmail(), inputData.getLocation());
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(employee.getId().toString(), employee.getName(), employee.getEmail(), employee.getLocation());
    }
}
