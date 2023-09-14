package com.bmw.employee;

import com.bmw.employee.dao.EmployeeDaoImpl;
import com.bmw.employee.entity.Employee;
import com.bmw.employee.exceptions.EmployeeExceptions;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeApplicationTests {

	private EntityManager entityManager = Mockito.mock(EntityManager.class);
	private EmployeeDaoImpl employeeDaoImpl;

	@BeforeEach
	void initUseCase() {
		employeeDaoImpl = new EmployeeDaoImpl(entityManager);
	}

	@Test
	void add_employee_test(){
		Employee addEmployee = new Employee();
		assertDoesNotThrow(() -> employeeDaoImpl.addEmployee(addEmployee));
	}

	@Test
	void get_employee_test(){
		Employee employeeToReturn = new Employee();
		employeeToReturn.setId(1);

		Mockito.when(entityManager.find(Employee.class,1)).thenReturn(employeeToReturn);
		assertEquals(employeeDaoImpl.getEmployee(1).getId(),1);

	}

	@Test
	void fail_to_get_employee_test(){
		Employee employeeToReturn = new Employee();
		employeeToReturn.setId(1);

		Mockito.when(entityManager.find(Employee.class,1)).thenReturn(employeeToReturn);
		assertThrows(EmployeeExceptions.EmployeeNotFound.class, () -> {employeeDaoImpl.getEmployee(2);});

	}
}
