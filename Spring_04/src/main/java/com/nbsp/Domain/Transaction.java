package com.nbsp.Domain;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Transaction {

/*
        @Autowired()
        private ConnectionUtils connectionUtils;*/



    /**
         * 开启事务
         */
        /*public  void beginTransaction(){
            try {
                connectionUtils.getThreadConnection().setAutoCommit(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        *//**
         * 提交事务
         *//*
        public  void commit(){
            try {
                connectionUtils.getThreadConnection().commit();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        *//**
         * 回滚事务
         *//*
        public  void rollback(){
            try {
                connectionUtils.getThreadConnection().rollback();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        *//**
         * 释放连接
         *//*
        public  void release(){
            try {
                connectionUtils.getThreadConnection().close();//还回连接池中
                connectionUtils.removeConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/








    public  void beginTransaction(){
        System.out.println("开启事务");
    }

    /**
     * 提交事务
     */
    public  void commit(){

        System.out.println("提交了");
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        System.out.println("异常了");
    }


    /**
     * 释放连接
     */
    public  void release(){
        System.out.println("释放了");
    }

    // 环绕通知 ProceedingJoinPoint
  //  @Around("around")
    public Object around(ProceedingJoinPoint pjp ){
    Object value=null;
    try{
        Object[] args = pjp.getArgs();
        System.out.println("开始记录日志");
        value = pjp.proceed(args);
        System.out.println("准备提交");

    }catch (Throwable throwable){
        System.out.println("异常了");
        throwable.printStackTrace();
    }finally{
        System.out.println("释放资源");
    }
    return value;
    }

}


