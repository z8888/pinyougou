package com.nbsp;


import com.nbsp.Service.AccountService;
import com.nbsp.domian.Account;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Bean.xml")
public class Test {
    @Autowired
    private AccountService ac;

    @org.junit.Test
    public void FindAll(){

        List<Account> accounts = ac.FindAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @org.junit.Test
    public void Translokigo(){

        ac.Translokigo("aaa","bbb",-500f);

    }

}
