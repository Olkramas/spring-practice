package com.example.demo.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect
public class AroundAdvice {
	
	//LogAdvice에 있는 allpointcut()
	@Around("LogAdvice.allpointcut()")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		//서비스 메서드 실행 전에 
		//현재시간을 체크함
		long start = System.currentTimeMillis();
		
		
		//서비스 메서도 호출
		obj = pjp.proceed();
		
		
		//서비스 실행후에 할 내용
		long end = System.currentTimeMillis();
		//걸린시간 출력
		log.info("Time: " + (end-start)); 
		return obj;
	}
}
