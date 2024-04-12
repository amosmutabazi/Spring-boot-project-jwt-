package com.learning.cruddemo.Service;

import com.learning.cruddemo.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
   

    public Optional<Role> findById(Long id);


   public Role updateRole(Role role);

   public Role deleteRole(Long id);


    public List<Role> listAllRole();

    public Role createRole(Role role);
}
