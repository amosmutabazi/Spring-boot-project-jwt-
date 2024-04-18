package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.SchoolService;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.exceptions.SchoolNotFoundException;
import com.learning.cruddemo.models.Department;
import com.learning.cruddemo.models.School;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor

public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @PostMapping("/create school")
    public String createSchool(School school){
        schoolService.createSchool(school);
        return "created successfully";
    }
    @GetMapping("/List all schools")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}/get sch by id")
    public School getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException, SchoolNotFoundException {
        return schoolService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("exceptions.notFound","Role", "id", id));
    }
    @DeleteMapping("/{id}/delete sch by id")
    public String deleteById(@PathVariable ("id") Long id) {
        return schoolService.deleteById(id);

    }
    @PutMapping("/update sch")
    public String updateSchool(School school){
         schoolService.updateSchool(school);
         return "updated successfully";
    }@GetMapping("/get_school by name")
    public School getSchoolByName(String name){
       return schoolService.getSchoolByName(name);
    }
}
