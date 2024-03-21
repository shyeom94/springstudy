package com.gdu.prj07.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 남기기 위한 선언 
@Aspect 
// @Component // Spring Container -> make class // 스프링 컨테이너에 Bean 으로 저장해 두시오. 
// <bean>, @Bean -> exist class 
public class MyAroundAspect {
    
  // PointCut : 언제 동작하는가?
  @Pointcut("execution (* com.gdu.prj07.controller.*Controller.*(..))") // 표현식. 언제 동작할 것인지를 결정하는 
  public void setPointCut() {} // 본문 없음. 할 일은 Advice 에 적는다.

  /*
   * Around Advice 메소드 작성 방법
   *  1. 반환타입 : Object  
   *  2. 메소드명 : 마음대로 작성
   *  3. 매개변수 : ProceedingJoinPoint 타입 객체  
   */
  
  // Advice   : 무슨 동작을 하는가?   
  @Around("setPointCut()")  
  public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // Exception 보다 상위 -> Throwable
    
    log.info("{}", "-".repeat(80));              // 동작 이전. (@Before 이전) 
    
    Object obj = proceedingJoinPoint.proceed();  // Advice 가 동작하는 시점 
    
    log.info("{}", "-".repeat(80));              // 동작 이후. (@After 이전) 
    
    return obj;
  }

}
