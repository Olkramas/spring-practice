package com.example.demo.insa.service;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpDTO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobTitle;
	private long salary;
	private double commissionPct;
	private int managerId;
	private String departmentName;
	
}
