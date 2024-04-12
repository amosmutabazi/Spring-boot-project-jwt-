package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.Department;
import com.learning.cruddemo.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepo departmentRepo;
    @Override

    public void createDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Long dept_id) {
        return departmentRepo.findById(dept_id);
    }


    @Override
    public String deleteDepartment(String dept_id) {
         departmentRepo.deleteById(Long.valueOf(dept_id));
        return "Successfull deleted";
    }

    @Override
    public Department updateDepartment(Department department, Long dept_id) {
        Department depDB = departmentRepo.findById(dept_id).get();
        if (Objects.nonNull(department.getDept_name())
        && !"".equalsIgnoreCase(department.getDept_name())){
            depDB.setDept_name(department.getDept_name());
        }
        if (Objects.nonNull(department.getDept_address())
                && !"".equalsIgnoreCase(department.getDept_address())){
            depDB.setDept_address(department.getDept_address());
        }
        if (Objects.nonNull(department.getDept_code())
                && !"".equalsIgnoreCase(department.getDept_code())){
            depDB.setDept_code(department.getDept_code());
        }
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }
}
