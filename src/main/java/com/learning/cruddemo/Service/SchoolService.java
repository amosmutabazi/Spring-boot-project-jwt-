package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.Department;
import com.learning.cruddemo.models.Role;
import com.learning.cruddemo.models.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

     void createSchool(School school);

   public   List<School> getAllSchools();


    public Optional<School> findById(Long id);

    public String deleteById(Long id);



    String updateSchool(School school);
}
