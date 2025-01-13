package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.di.TV;

@SpringBootTest
public class DiTest {
	/*
	 @Component를 선언한 클래슬 모두 순환하여 객체로 만듦
	 
	 그걸 꺼내서 주입받을때는 @Autowired
	 * */
	@Autowired TV tv;
	//@Autowired ApplicationContext context; //Spring 빈을 담고있는 컨테이너
	
	@Test
	@DisplayName("객체 생성")
	public void test() {
		//TV tv = context.getBean(TV.class);

		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
