package com.arun.projects.SpringMVC_MongoDB_EMS.Service.Impl;

import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import com.arun.projects.SpringMVC_MongoDB_EMS.Data.DataResponse;
import com.arun.projects.SpringMVC_MongoDB_EMS.Data.PaginationMeta;
import com.arun.projects.SpringMVC_MongoDB_EMS.Exception.EmployeeIdExistException;
import com.arun.projects.SpringMVC_MongoDB_EMS.Exception.EmployeeIdNotFoundException;
import com.arun.projects.SpringMVC_MongoDB_EMS.Exception.NoEmployeesFoundException;
import com.arun.projects.SpringMVC_MongoDB_EMS.Mapper.EmployeeMapper;
import com.arun.projects.SpringMVC_MongoDB_EMS.Model.Employee;
import com.arun.projects.SpringMVC_MongoDB_EMS.Repository.EmployeeRepository;
import com.arun.projects.SpringMVC_MongoDB_EMS.Service.EmployeeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeServices {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO newEmployee) {
        Employee employee= EmployeeMapper.mapToEmployee(newEmployee);

        if(employeeRepository.existsById(employee.getId()))
            throw new EmployeeIdExistException("Given employee ID: "+ employee.getId() +" Already Exist");

        Employee retriveSavedEmployee =employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(retriveSavedEmployee);
    }

    @Override
    public DataResponse getAllEmployee(Pageable pageable) {

        Page<Employee> retriveEmployees= employeeRepository.findAll(pageable);

        if(retriveEmployees.isEmpty())
            throw new NoEmployeesFoundException("No Employees Found in Database");

        List<EmployeeDTO> employeeDetails = retriveEmployees.stream().map(EmployeeMapper::mapToEmployeeDTO).toList();
        PaginationMeta paginationDetails = new PaginationMeta(
                                        retriveEmployees.getNumber()+1,
                                        retriveEmployees.getTotalPages(),
                                        retriveEmployees.getSize(),
                                        retriveEmployees.getNumberOfElements(),
                                        retriveEmployees.getTotalElements(),
                                        retriveEmployees.isFirst(),
                                        retriveEmployees.isLast(),
                                        retriveEmployees.getSort().toString()
                                        );
        return new DataResponse(employeeDetails, paginationDetails);
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        Employee employee =  employeeRepository.findById(id)
                            .orElseThrow( () -> new EmployeeIdNotFoundException
                             ("Given Employee ID : " + id + " does not exist") );
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }
    @Override
    public List<Integer> getAllEmployeesId(){
        return employeeRepository.findOnlyEmployeesId();
    }
}
