package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.di.SampleDto;

import lombok.Data;

@Data
public class SampleDtoList {
	List<SampleDto> list = new ArrayList<>();
	
}
