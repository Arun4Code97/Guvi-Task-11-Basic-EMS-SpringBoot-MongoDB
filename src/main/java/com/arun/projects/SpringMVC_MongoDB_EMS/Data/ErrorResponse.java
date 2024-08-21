package com.arun.projects.SpringMVC_MongoDB_EMS.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    String httpStatusCode;
    Object errorMessage;
}
