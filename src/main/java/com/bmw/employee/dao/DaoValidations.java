package com.bmw.employee.dao;

import com.bmw.employee.controller.EmployeeController;
import com.bmw.employee.entity.Employee;
import com.bmw.employee.exceptions.EmployeeExceptions;
import io.micrometer.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DaoValidations {

    private static Log log = LogFactory.getLog(DaoValidations.class);

    public static void employeeValidation(Employee employee){
        if(employee != null && !StringUtils.isBlank(employee.getName()) && !StringUtils.isBlank(employee.getSurname())  && !StringUtils.isBlank(employee.getSurname())){

        }else{
            log.error("Employee object has invalid fields");
            throw new EmployeeExceptions.InvalidRequest("");
        }

    }
}
