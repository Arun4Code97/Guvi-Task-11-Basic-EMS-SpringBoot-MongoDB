package com.arun.projects.SpringMVC_MongoDB_EMS.Controller;

import com.arun.projects.SpringMVC_MongoDB_EMS.Data.DataResponse;
import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import com.arun.projects.SpringMVC_MongoDB_EMS.Service.EmployeeServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Handling REST API requests and returning response as JSON data
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeRESTController {
    // Constructor based dependency Injection
    private final EmployeeServices employeeServices;

    @PostMapping("/addAnEmployee")
    public ResponseEntity<EmployeeDTO> addAnEmployee(@Valid @RequestBody EmployeeDTO newEmployee){

        EmployeeDTO savedEmployee= employeeServices.addEmployee(newEmployee);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }
    @GetMapping("/displayAll")
    public ResponseEntity<DataResponse> getAllEmployee(@RequestParam(name = "pageNumber",defaultValue ="1",required = false) Integer pageNumber,
                                                       @RequestParam(name = "pageSize",defaultValue = "5",required = false) Integer pageSize,
                                                       @RequestParam(name ="sortBy",defaultValue = "name",required = false) String sortBy){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize, Sort.by(sortBy));
        DataResponse response = employeeServices.getAllEmployee(pageable);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<EmployeeDTO> getAnEmployeeByID(@PathVariable Integer id){
        EmployeeDTO retrivedEmployee = employeeServices.getEmployeeById(id);
        return new ResponseEntity<>(retrivedEmployee,HttpStatus.OK);
    }

}
