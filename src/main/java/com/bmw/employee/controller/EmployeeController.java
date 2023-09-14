package com.bmw.employee.controller;

import com.bmw.employee.dao.DaoValidations;
import com.bmw.employee.dao.EmployeeDao;
import com.bmw.employee.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    Log log = LogFactory.getLog(EmployeeController.class);

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @PostMapping("/employees")
    @Transactional
    void addEmployee(@RequestBody Employee employee) {
        log.info("Adding employee " + employee);
        DaoValidations.employeeValidation(employee);
        employeeDao.addEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    Employee getEmployee(@PathVariable int id) {
        log.info("Get employee " + id);
        return employeeDao.getEmployee(id);
    }

    @GetMapping("/employees")
    List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @DeleteMapping("/employees/{id}")
    @Transactional
    void deleteEmployee(@PathVariable int id) {
        log.info("Delete employee " + id);
        employeeDao.deleteEmployee(id);
    }


    @PutMapping("/employees")
    @Transactional
    void updateEmployee(@RequestBody Employee employee) {
        log.info("Update employee " + employee);
        DaoValidations.employeeValidation(employee);
        employeeDao.updateEmployee(employee);
    }
}

