package com.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@Table(name = "employee")
public class Employee {

    @Id // khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
    private int id;

    private String fullName;

    private String email;

    private String phone;

    // ORM: Object-Relational Mapping
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
