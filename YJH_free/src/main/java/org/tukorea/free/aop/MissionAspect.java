package org.tukorea.free.aop;

import java.security.Signature;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tukorea.free.controller.HomeController;
import org.tukorea.free.domain.MissionVO;

@Aspect
@Component
public class MissionAspect {
	private static final Logger logger = LoggerFactory.getLogger(MissionAspect.class);

	
	@Before("execution(* org.tukorea.free.controller..*.*(..))")
	public void beforeMethod(JoinPoint jp) {
		System.out.println(" 메소드 호출 전");
		org.aspectj.lang.Signature sig = jp.getSignature();
		logger.info(" 메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		logger.info(" 인자 값 : " + obj[0]);
	}
	
	@After(value = "execution(* org.tukorea.free.controller..*.*(..))")
	public void afterReturningMethod(JoinPoint jp) {
		System.out.println(" 메소드 호출 후");
		org.aspectj.lang.Signature sig = jp.getSignature();
		logger.info(" 메소드 이름 : " + sig.getName());
		Object[] obj = jp.getArgs();
		logger.info(" 인자 값 : " + obj[0]);

	}
	
}