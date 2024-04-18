package com.learning.cruddemo.Service.impl;

import com.learning.cruddemo.Service.SchoolService;
import com.learning.cruddemo.exceptions.SchoolNotFoundException;
import com.learning.cruddemo.models.School;
import com.learning.cruddemo.repositories.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;
    @Override
    public void createSchool(School school) {
        schoolRepo.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public Optional<School> findById(Long id) throws SchoolNotFoundException {
        if (schoolRepo.findById(id).isEmpty()) {
            throw new SchoolNotFoundException("school not found");
        }
        return schoolRepo.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        schoolRepo.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public String updateSchool(School school) {
        schoolRepo.save(school);
        return "updated successfully";
    }

    @Override
    public School getSchoolByName(String name) {
        return schoolRepo.findByNameIgnoreCase(name);
    }


}
