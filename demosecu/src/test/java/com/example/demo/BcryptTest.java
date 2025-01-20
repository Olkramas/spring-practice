package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
	
	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);	//4-31 사이 값으로 강도를 설정할 수 있다.
		String result = encoder.encode("1234");
		
		System.out.println(result);
		assertThat(encoder.matches("1234", result));
	}
}
