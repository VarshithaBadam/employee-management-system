package com.varshitha.employee_management  .service;

import com.varshitha.employee_management.model.Employee;
import com.varshitha.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = repo.findById(id).orElseThrow();
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        existing.setRole(emp.getRole());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}