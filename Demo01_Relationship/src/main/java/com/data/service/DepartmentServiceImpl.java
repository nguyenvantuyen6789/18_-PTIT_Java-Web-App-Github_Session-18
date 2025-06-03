package com.data.service;

import com.data.entity.Department;
import com.data.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepo;

    public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }
}
