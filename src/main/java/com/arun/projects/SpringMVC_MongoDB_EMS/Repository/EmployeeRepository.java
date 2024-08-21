package com.arun.projects.SpringMVC_MongoDB_EMS.Repository;

import com.arun.projects.SpringMVC_MongoDB_EMS.Model.Employee;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {

// Using Native MongoDB Aggregation annotation for retrieving only id in the result
@Aggregation(pipeline = {
        "{ $project: { id: 1 } }"
            })
List<Integer> findOnlyEmployeesId();

}
