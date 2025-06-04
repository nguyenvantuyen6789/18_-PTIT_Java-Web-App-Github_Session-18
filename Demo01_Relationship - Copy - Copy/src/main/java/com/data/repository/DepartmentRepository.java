package com.data.repository;

import com.data.entity.Department;

import java.util.List;

public interface DepartmentRepository {

    List<Department> findAll();

    int delete(int id);

    int save(Department department);

    int update(Department department);
}
