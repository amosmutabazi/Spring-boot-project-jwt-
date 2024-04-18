package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.CourseService;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("create course")
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return "successfully added";
    }

    @GetMapping("/{id}/course list")
    public Optional<Course> getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);

    }

    @GetMapping("/list all courses")
    public List<Course> fetchCourseList() {
        return courseService.fetchCourseList();

    }

    @DeleteMapping("/{id}/delete course by id")
    public String deleteCourse(@PathVariable("id") String id) {
        return courseService.deleteCourse(Long.valueOf(id));

    }

    @PutMapping("/{id}/update course") // Endpoint for updating a course by ID
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) throws ResourceNotFoundException {
        return courseService.updateCourse(course, id);
    }
    @GetMapping("/fetch course by name")

    public Course getCourseByName(String name) {
        return courseService.getCourseByName(name);
    }
}

