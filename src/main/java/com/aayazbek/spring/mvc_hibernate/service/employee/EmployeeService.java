package com.aayazbek.spring.mvc_hibernate.service.employee;

import com.aayazbek.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    List<Employee> findBySurname(String surname);
}
