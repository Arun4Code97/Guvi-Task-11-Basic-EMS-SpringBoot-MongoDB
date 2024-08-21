package com.arun.projects.SpringMVC_MongoDB_EMS.Service;

import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import com.arun.projects.SpringMVC_MongoDB_EMS.Data.DataResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeServices {
    public EmployeeDTO addEmployee(EmployeeDTO newEmployee);
    public DataResponse getAllEmployee(Pageable pageable);
    public EmployeeDTO getEmployeeById(Integer employeeId);
    public List<Integer> getAllEmployeesId();

}
