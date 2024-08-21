package com.arun.projects.SpringMVC_MongoDB_EMS.Data;

import com.arun.projects.SpringMVC_MongoDB_EMS.DTO.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class DataResponse {
    List<EmployeeDTO> employeeDetails;
    PaginationMeta paginationDetails;
}
