package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.DepartmentService;
import com.learning.cruddemo.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public String createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return "created successfully";
    }
    @DeleteMapping("departments/{dept_id}")
    public String deleteDepartment(@PathVariable ("dept_id") String dept_id){
        return departmentService.deleteDepartment(dept_id);

    }
    @GetMapping("/departments/{dept_id}")
    public Optional<Department> getDepartmentById(@PathVariable ("dept_id") String dept_id){
        return departmentService.getDepartmentById(Long.valueOf(dept_id));
    }
    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @PutMapping("/deparments")
    public Department updateDepartment(@RequestBody Department department, @PathVariable ("dept_id") String dept_id){
        return departmentService.updateDepartment(department, Long.valueOf(dept_id));
    }

}
