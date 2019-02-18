package com.nbsp;


import com.nbsp.Service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Bean.xml")
public class Test {

    @Autowired
    private AccountService  ac;

    @org.junit.Test
    public void Translokigo(){
        ac.Translokigo("aaa","bbb",1000f);
    }

}
/**/