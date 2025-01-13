package com.example.demo.di;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SonySpeaker implements Speaker {
	
	final Speaker speaker;
	
	public SonySpeaker(){		
		this.speaker = null;
		System.out.println("Sony Speaker 생성");	
	}

	@Override
	public void volumeUp(){
		System.out.println("Sony Speaker 소리 올림");
	}

	@Override
	public void volumeDown(){
		System.out.println("Sony Speaker 소리 내림");
	}
}