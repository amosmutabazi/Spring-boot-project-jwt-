package com.learning.cruddemo.models;

import jakarta.persistence.*;
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
    private String dept_name;
    private String dept_address;
    private  String dept_code;
}
