package com.nbsp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    @Test
    public void  Test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        Text01 text = (Text01) ac.getBean("text");
        text.saveAccount();
    }
}
