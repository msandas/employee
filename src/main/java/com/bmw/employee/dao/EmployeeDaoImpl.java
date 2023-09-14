package com.bmw.employee.dao;

import com.bmw.employee.entity.Employee;
import com.bmw.employee.exceptions.EmployeeExceptions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private static Log log = LogFactory.getLog(EmployeeDaoImpl.class);
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        if(employee != null){
            return employee;
        }else {
            log.error("Failed to find an employee of id "+id);
            throw new EmployeeExceptions.EmployeeNotFound(id);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        TypedQuery<Employee> returnAllQuery = this.entityManager.createQuery("from Employee",Employee.class);
        return returnAllQuery.getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
            this.entityManager.merge(employee);
    }

    @Override
    public void updateEmployee(Employee employee){
        Employee toBeUpdated = this.entityManager.find(Employee.class,employee.getId());

        if(toBeUpdated !=null ){
            this.entityManager.merge(employee);
        }else{
            log.error("Failed to find an employee of id "+employee.getId()+" to update.");
            throw new EmployeeExceptions.EmployeeNotFound(employee.getId());
        }

    }


    @Override
    public void deleteEmployee(int id) {
        Employee toBeDeleted = this.entityManager.find(Employee.class,id);

        if(toBeDeleted != null){
            entityManager.remove(toBeDeleted);
        }else {
            log.error("Failed to find an employee of id "+id+" to remove.");
            throw new EmployeeExceptions.EmployeeNotFound(id);
        }
    }
}
