package com.arun.projects.SpringMVC_MongoDB_EMS.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Employee")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String location;
}
