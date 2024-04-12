package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.RoleService;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    @Autowired

    private RoleService roleService;


    @PostMapping
   public String createRole(Role role){
         roleService.createRole(role);
        return "created successfully";
    }
    @GetMapping("/{id}")
    public Role getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return roleService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("exceptions.notFound","Role", "id", id));
    }

    @PutMapping("/roles")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }
    @DeleteMapping("/{id}")
    public Role deleteRole(@PathVariable("id") Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping("/roles")
    public List<Role> listAllRole(){
        return roleService.listAllRole();
    }

}
