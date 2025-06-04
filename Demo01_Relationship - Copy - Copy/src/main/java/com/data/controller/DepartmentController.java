package com.data.controller;

import com.data.dto.DepartmentDTO;
import com.data.entity.Department;
import com.data.entity.Employee;
import com.data.repository.DepartmentRepository;
import com.data.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    private DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentService departmentService,
                                DepartmentRepository departmentRepo) {
        this.departmentService = departmentService;
        this.departmentRepo = departmentRepo;
    }

    @GetMapping("department")
    public String getAll(Model model) {
        List<Department> departments = departmentService.findAll();
        List<Employee> employees = departments.get(0).getEmployees();
        List<Employee> employees1 = departments.get(1).getEmployees();
        List<Employee> employees2 = departments.get(2).getEmployees();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setDepartmentName(department.getDepartmentName());
            departmentDTOs.add(departmentDTO);
        });

        System.out.println(departmentDTOs);

        model.addAttribute("departmentDTOs", departmentDTOs);
        return "department_list";
    }

    @GetMapping("department/{id}")
    public String getAll(@PathVariable int id) {
        departmentService.delete(id);
        return "redirect:/department";
    }

    @GetMapping("department-save")
    public String save() {
        departmentRepo.save(null);
        return "redirect:/department";
    }

    @GetMapping("department-update")
    public String update() {
        departmentRepo.update(null);
        return "redirect:/department";
    }
}
