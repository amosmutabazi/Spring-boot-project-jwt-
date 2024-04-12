package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.Role;
import com.learning.cruddemo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoleServiceImp implements RoleService{
    @Autowired
    private RoleRepository roleRepository;




    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role deleteRole(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role deletedRole = roleOptional.get();
            roleRepository.deleteById(id);
            return deletedRole;
        } else {
            // Handle the case where the role with the given ID doesn't exist
            return null; // or throw an exception
        }
    }


    @Override
    public List<Role> listAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }


}
