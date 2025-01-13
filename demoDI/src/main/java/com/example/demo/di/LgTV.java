package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//final 생성자 초기화
//@RequiredArgsConstructor
//
//@AllArgsConstructor
//@NoArgConstructor

@Data
//@Component
public class LgTV implements TV{
	
	/*
	// 1. 필드 주입 방식
	Speaker speaker;
	
	// 3. 생성자 주입방법 : 가장 권장하는 방식
	@Autowired
	public LgTV(Speaker speaker) {
		System.out.println("constructor injection");
		this.speaker = speaker;
	}
	
	// 2. setter
	public void setSpeaker(Speaker speaker) {
		
		System.out.println("setter injection");
		this.speaker = speaker;
	}
	*/
	
	/*
	//lombok @Data를 사용했을때 setter위에 Autowired를 사용할때 아래와 같은 방식으로 사용
	@Setter(onMethod_ = {@Autowired})
	Speaker speaker;
	*/
	
	//final이 붙으면 자동으로 autowired가 붙음
	final Speaker speaker;
	int price;
	
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		//System.out.println("LG TV--볼륨 up");
		speaker.volumeUp();
	}
	public void volumeDown() {
		//System.out.println("LG TV--볼륨 down");
		speaker.volumeDown();
	}
}