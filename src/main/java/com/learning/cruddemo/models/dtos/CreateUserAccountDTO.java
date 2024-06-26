package com.learning.cruddemo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserAccountDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String role;

    private String password;
}
