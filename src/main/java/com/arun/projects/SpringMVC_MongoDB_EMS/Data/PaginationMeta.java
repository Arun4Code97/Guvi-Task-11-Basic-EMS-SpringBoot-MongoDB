package com.arun.projects.SpringMVC_MongoDB_EMS.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationMeta {
    Integer currentPageNumber;
    Integer availableTotalPages;
    Integer currentPageSize;
    Integer currentPageEmployeesCount;
    Long totalEmployees;
    Boolean isFirstPage;
    Boolean isLastPage;
    String sortBy;
}
