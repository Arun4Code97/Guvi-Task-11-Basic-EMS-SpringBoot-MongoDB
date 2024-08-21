package com.arun.projects.SpringMVC_MongoDB_EMS.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Employee Id must not be blank")
    @Pattern(regexp = "^[0-9]+$", message = "Employee Id must contain only numeric characters")
    private String id;


    @NotBlank(message = "Employee Id must not be blank")
    private String name;

    @NotBlank(message = "Employee email must not be blank")
    @Email(message = "Employee Email must be valid")
    private String email;

    @NotBlank(message = "Employee location must not be blank")
    private String location;
}
