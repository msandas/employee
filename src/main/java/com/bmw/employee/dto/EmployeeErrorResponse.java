package com.bmw.employee.dto;

import lombok.Data;

@Data
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
