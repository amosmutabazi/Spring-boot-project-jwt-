package com.learning.cruddemo.Service;

import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public Course addCourse(Course course);
    public Optional<Course> getCourseById(Long id);
    public List<Course> fetchCourseList();
    public String deleteCourse(Long id);





    Course updateCourse(Course course, Long id) throws ResourceNotFoundException;

    public Course getCourseByName(String name);
}
