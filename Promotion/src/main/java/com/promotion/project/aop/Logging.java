package com.promotion.project.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

   @Pointcut("execution(* com.promotion.project.service.*.*(..))")
   private void log(){}

   @Before("log()")
   public void beforeAdvice(){
      System.out.println("before");
   }
   @After("log()")
   public void afterAdvice(){
      System.out.println("after");
   }

   @AfterReturning(pointcut = "log()", returning="retVal")
   public void afterReturningAdvice(Object retVal){
      System.out.println("afterReturningAdvice" + retVal.toString() );
   }
   @AfterThrowing(pointcut = "log()", throwing = "ex")
   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("AfterThrowingAdvice " + ex.toString());   
   }

}