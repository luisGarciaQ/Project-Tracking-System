package com.lagq.ms_employee.service;

import com.lagq.ms_employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lagq.ms_employee.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(int id, Employee updatedEmployee)
    {
        Employee existing = getEmployeeById(id);
        existing.setUsername(updatedEmployee.getUsername());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setFirstName(updatedEmployee.getFirstName());
        existing.setLastName(updatedEmployee.getLastName());
        existing.setPassword(updatedEmployee.getPassword());
        existing.setRole(updatedEmployee.getRole());
        return employeeRepository.save(existing);
    }

    public void deleteEmployee(int id)
    {
        employeeRepository.deleteById(id);
    }
}
