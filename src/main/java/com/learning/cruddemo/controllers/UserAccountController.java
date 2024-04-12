package com.learning.cruddemo.controllers;

import com.learning.cruddemo.Service.UserService;
import com.learning.cruddemo.exceptions.ResourceNotFoundException;
import com.learning.cruddemo.exceptions.UserLoginException;
import com.learning.cruddemo.models.Role;
import com.learning.cruddemo.models.UserAccount;
import com.learning.cruddemo.models.dtos.CreateUserAccountDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserAccountController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public List<UserAccount> getAll(){

        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return userService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("exceptions.notFound","UserAccount", "id", id));}
    @PostMapping
    public String createUser(@RequestBody UserAccount userAccount){
         userService.createUser(userAccount);
        return "created successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable ("id") Long id){
        return userService.deleteUser(id);
    }
    @PutMapping("/users")
    public String updateUser(@RequestBody UserAccount userAccount,@PathVariable ("id") Long id){
        return userService.updateUser(userAccount, id);
    }


}
