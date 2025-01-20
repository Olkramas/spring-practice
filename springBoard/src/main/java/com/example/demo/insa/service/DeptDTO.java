package com.example.demo.insa.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptDTO {
	private long departmentId;
	private String departmentName;
	private Long managerId;
	private String locationId;
	
}
