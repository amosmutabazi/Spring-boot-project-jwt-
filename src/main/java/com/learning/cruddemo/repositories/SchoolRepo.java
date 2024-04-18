package com.learning.cruddemo.repositories;

import com.learning.cruddemo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SchoolRepo extends JpaRepository <School, Long> {
    public School findByNameIgnoreCase(String name);
}
