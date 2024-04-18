package com.learning.cruddemo.repositories;

import com.learning.cruddemo.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    public Department findByDeptname(String dept_name);
}

