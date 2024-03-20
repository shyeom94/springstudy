package com.gdu.prj06.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class MyAfterAspect {
  
  // PointCut
  @Pointcut("excution (* com.gdu.prj06.controller.*Controller.*(..))") // 모든 컨트롤러의 모든 메소드에서 동작한다. 
  public void setPointCut() {}
  
  // Advice
  /*
   * Before Advice method 작성 방법 
   * 
   * 1. 반환타입 : void 
   * 2. 메소드명 : 마음대로 
   * 3. 매개변수 : JoinPoint 타입 객체
   */  
  @After("setPointCut()")
  public void myAfterAdvice(JoinPoint joinPoint) {
    
    log.info("{}\n", "-".repeat(80));
    
  }
  
}
