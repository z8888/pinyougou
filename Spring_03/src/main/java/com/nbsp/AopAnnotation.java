package com.nbsp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

    @Aspect // 代表当前是个切面类
 @Component("aopAnnotation")
 public class AopAnnotation {

    /*@Before("execution(* com.nbsp.Service.*.*(..))")
    public void befor(){
        System.out.println("开始执行了....");
    }
    @AfterThrowing("execution(* com.nbsp.Service.*.*(..))")
    public void AfterThrowing(){
        System.out.println("异常了....");
    }
    @AfterReturning("execution(* com.nbsp.*.*.*(..))")
    public void AfterReturning(){
        System.out.println("提交了....");
    }
    @After("execution(* com.nbsp.Service.*.*(..))")
    public void After(){
        System.out.println("执行完毕。。。。");
    }*/

    @Around(value = "execution(* com.nbsp.Service.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
            Object value=null;

           try {
               System.out.println("开始执行.....1");
               // 获取执行的参数
               Object[] args = proceedingJoinPoint.getArgs();
               System.out.println("正在运行中.....2");
               // 执行方法
              value= proceedingJoinPoint.proceed(args);
               System.out.println("准备提交.....3");
           }catch (Throwable throwable){
               System.out.println("异常了。。。。4");
               throw new RuntimeException("出错了。。。");
           }
            return value;
    }

}
