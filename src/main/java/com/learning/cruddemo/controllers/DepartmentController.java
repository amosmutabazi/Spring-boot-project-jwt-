package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.DepartmentService;
import com.learning.cruddemo.exceptions.DepartmentNotFoundException;
import com.learning.cruddemo.models.Department;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departments")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/create dep")
    public String createDepartment(@RequestBody Department department){
        LOGGER.info("Inside createDepartment of DepartmentController ");
        departmentService.createDepartment(department);
        return "created successfully";
    }

    @DeleteMapping("/{dept_id}/delete dep")
    public String deleteDepartment(@PathVariable ("dept_id") String dept_id){
        LOGGER.info("Inside deleteDepartment of DepartmentController ");
        return departmentService.deleteDepartment(dept_id);

    }
    @GetMapping("/{dept_id}/fetch dep by id")
    public Optional<Department> getDepartmentById(@PathVariable ("dept_id") String dept_id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(Long.valueOf(dept_id));
    }
    @GetMapping("/fetch dep list")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @PutMapping("/update dep")
    public Department updateDepartment(@RequestBody Department department, @PathVariable ("dept_id") String dept_id){
        return departmentService.updateDepartment(department, Long.valueOf(dept_id));
    }
    @GetMapping("/{deptname}/fetch dep by name")
    public Department getDepartmentByName(@Valid @PathVariable ("deptname") String deptname){
        return departmentService.getDepartmentByName(deptname);

    }


}
