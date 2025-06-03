package com.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data // ham toString gay loi cho MQH trong hibernate
@Getter
@Setter
@Table(name = "department")
public class Department {

    @Id // khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
    private int id;

    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
