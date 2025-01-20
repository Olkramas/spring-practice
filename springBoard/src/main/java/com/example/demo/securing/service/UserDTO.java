package com.example.demo.securing.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO {
//	  ID           number primary key,
//	  LOGIN_ID    varchar2(20)   not null,
//	  PASSWORD  varchar2(200)  not null,
//	  FULL_NAME  varchar2(100)  not null,
//	  DEPT_NAME  varchar2(100)  not null
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	
	private List<RoleDTO> roles;
	
	/*
	 * 
	 * implements UserDetails로 메서드 오버라이딩
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> role = new ArrayList<>();
		
		roles.forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));
		
		return role;
	}

	@Override
	public String getUsername() {
		return loginId;
	}
	*/
}
