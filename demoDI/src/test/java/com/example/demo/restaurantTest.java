package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.restaurant.Restaurant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class restaurantTest {
	
	@Autowired Restaurant restaurant;
	
	@Test
	public void dites2() {
		restaurant.getChef().getName();
	}
}
