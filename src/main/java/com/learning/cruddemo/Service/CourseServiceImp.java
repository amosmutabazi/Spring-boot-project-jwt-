package com.learning.cruddemo.Service;

import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.Course;
import com.learning.cruddemo.repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CourseServiceImp implements CourseService{
    @Autowired
    private CourseRepo courseRepo;


    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> fetchCourseList() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteCourse(Long id) {
        courseRepo.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public Course updateCourse(Course course, Long id) throws ResourceNotFoundException {
        // Retrieve the course by ID
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        // Update the existing course with the new information
        existingCourse.setName(course.getName());
       // existingCourse.setName(course.getDepartment());
        // Update other fields as needed

        // Save the updated course
        return courseRepo.save(existingCourse);
    }


}



