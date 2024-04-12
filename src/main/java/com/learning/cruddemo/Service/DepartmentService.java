package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void createDepartment(Department department);


    Optional<Department> getDepartmentById(Long dept_id);

    public  String deleteDepartment(String dept_id);
    public Department updateDepartment(Department department, Long dept_id);
    public List<Department> getAllDepartment();
}
