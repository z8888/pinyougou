package com.nbsp;


import com.nbsp.Bean.Account;
import com.nbsp.Service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Bean.xml"})
public class Test {

    @Autowired
    private AccountService as;

    @org.junit.Test
    public void TextTranslokigo(){
        System.out.println(as);
        List<Account> accounts = as.FindAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

}
