package com.bmw.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@Getter @Setter @ToString
public class Employee {

    @Id
    private int id;
    private String name;
    private String surname;
    private Long salary;
    private boolean employed;
}
