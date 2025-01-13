package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.di.SampleDto;

public class lombokTest {
	@Test
	public void test() {
		
		
		SampleDto dto = SampleDto.builder()
								 .name("aaa")
								 //.tel("a")
								 .age(20)
								 .build();
	}
}
