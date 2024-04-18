package com.learning.cruddemo.repositories;

import com.learning.cruddemo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
    public Course findByNameIgnoreCase(String name);
}
