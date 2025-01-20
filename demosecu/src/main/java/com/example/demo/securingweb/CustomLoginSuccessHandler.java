package com.example.demo.securingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.securing.service.CustomUser;
import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response,
										Authentication auth) throws IOException, ServletException {
		//단건조회
		UserDTO dto = ((CustomUser)auth.getPrincipal()).getUserDTO();
		
		//session에 아이디랑 부서명 담기
		request.getSession().setAttribute("userid", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		//username, roll정보 모두 받아낼 수 있음
		List<String> roleNames = new ArrayList<String>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("roleName: " + roleNames);
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		} else if ( roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/hello");
			return;
		}
		
		response.sendRedirect("/");
	}

}
