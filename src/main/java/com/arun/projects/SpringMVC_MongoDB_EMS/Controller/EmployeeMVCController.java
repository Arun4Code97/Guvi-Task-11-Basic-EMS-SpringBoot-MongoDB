package com.arun.projects.SpringMVC_MongoDB_EMS.Controller;



import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import com.arun.projects.SpringMVC_MongoDB_EMS.Service.EmployeeServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller // Handling MVC request and returning response as HTML page
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeMVCController {

    // Constructor based dependency Injection
    private final EmployeeServices employeeServices;
    @GetMapping
    public String getEmployeeHomePage(){
        return "home";
    }

    @GetMapping("/addEmployee")
    public String getEmployeeForm(Model model){
        EmployeeDTO newEmployee = new EmployeeDTO();
        model.addAttribute("newEmployee",newEmployee);
        model.addAttribute("existEmployeeId",null);
        return "employee-form";
    }

    @PostMapping("/addEmployee")
    public String addAnEmployee(@Valid @ModelAttribute("newEmployee") EmployeeDTO newEmployee, BindingResult result, Model model){

        // Handle validation errors and responses in the front end - Primary Checkup
        if(result.hasErrors()){
            return "employee-form";
        }

        // Checks if an employee already exists - Secondary check up
        // Used MongoDB - Aggregation Framework for fetching only ID from the database ,Used here for exploring purpose, Can be replaced by existById() method from CRUD repository
        List<Integer> retrieveAllId = employeeServices.getAllEmployeesId();
        Integer givenEmployeeId= Integer.parseInt(newEmployee.getId());

        if (retrieveAllId.contains(givenEmployeeId)){
            model.addAttribute("existEmployeeId",givenEmployeeId);
        }

        // Handle employee existence and responses in the front end
        if(model.containsAttribute("existEmployeeId")){
            return "employee-form";
        }

        // Saves new employee into database after performing both Validation and Employee existence.
        EmployeeDTO savedEmployee = employeeServices.addEmployee(newEmployee);
        model.addAttribute("savedEmployee",savedEmployee);

        return "form-submission-response";
    }


}


