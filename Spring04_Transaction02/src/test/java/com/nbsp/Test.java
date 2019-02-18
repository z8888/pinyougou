package com.nbsp;


import com.nbsp.domian.Account;
import com.nbsp.domian.Service.AccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:Bean.xml")
public class Test {

    @Autowired
    private AccountService ac;

    @org.junit.Test
    public void TranslokigoAccount(){
       /* List<Account> accounts = ac.FindAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }*/
       ac.Translokigo("aaa","bbb",500f);
    }
    @org.junit.Test
    public void FindAccount() {

        List<Account> accounts = ac.FindAccountAll();
        System.out.println(accounts);

    }
}
