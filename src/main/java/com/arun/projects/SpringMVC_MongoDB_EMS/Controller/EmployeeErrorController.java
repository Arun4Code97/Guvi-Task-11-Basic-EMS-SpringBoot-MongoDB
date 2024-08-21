package com.arun.projects.SpringMVC_MongoDB_EMS.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE;

// Returning a customized error response page instead of default white label error page
@Controller
public class EmployeeErrorController implements ErrorController {
    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model)
    {
        Object httpStatus= request.getAttribute(ERROR_STATUS_CODE);
        String errorMessage ="Unknown Error Occurred";
        if(httpStatus != null){
            int httpStatusCode = Integer.parseInt(httpStatus.toString());
            if(httpStatusCode == 404){
                errorMessage= "Page not found,check your end point\n";
            } else if (httpStatusCode == 405) {
                errorMessage = "Page not found,check your end point request type(PUT/POST) \n ";
            } else if(httpStatusCode == 500) {
                errorMessage ="Internal Server Error";
            }
            model.addAttribute("statusCode",httpStatusCode);
        }
        model.addAttribute("errorMessage",errorMessage);
        return "error";
    }
}
