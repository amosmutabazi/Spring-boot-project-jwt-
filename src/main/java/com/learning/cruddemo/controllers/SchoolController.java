package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.SchoolService;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.Role;
import com.learning.cruddemo.models.School;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor

public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @PostMapping("/schools")
    public String createSchool(School school){
        schoolService.createSchool(school);
        return "created successfully";
    }
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return schoolService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("exceptions.notFound","Role", "id", id));
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable ("id") Long id) {
        return schoolService.deleteById(id);

    }
    @PutMapping("/schools")
    public String updateSchool(School school){
         schoolService.updateSchool(school);
         return "updated successfully";
    }
}
