package com.example.demo.securing.mappers;

import java.util.List;

import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;


public interface UserMapper {
	
	//유저 조회
	public UserDTO getUser(String loginId);
	//권한 조회
	public List<RoleDTO> getRole(Long id);
}
