package com.learning.cruddemo.Service;

import com.learning.cruddemo.exceptions.SchoolNotFoundException;
import com.learning.cruddemo.models.Department;
import com.learning.cruddemo.models.School;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

     void createSchool(School school);

   public   List<School> getAllSchools();


    public Optional<School> findById(Long id) throws SchoolNotFoundException;

    public String deleteById(Long id);



    public String updateSchool(School school);

    public School getSchoolByName(String name);
}
