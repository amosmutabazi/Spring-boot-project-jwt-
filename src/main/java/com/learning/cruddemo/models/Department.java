package com.learning.cruddemo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deptment_tb")

public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long dept_id;
    @NotBlank (message = "Please enter department name")
    private String deptname;
    private String dept_address;
    private  String dept_code;

}
