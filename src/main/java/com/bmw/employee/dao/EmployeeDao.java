package com.bmw.employee.dao;

import com.bmw.employee.entity.Employee;
import com.bmw.employee.exceptions.EmployeeExceptions;

import java.util.List;

public interface EmployeeDao {
    Employee getEmployee(int id) throws EmployeeExceptions.EmployeeNotFound;
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);

}
