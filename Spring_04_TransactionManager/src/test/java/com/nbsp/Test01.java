package com.nbsp;

import com.nbsp.Bean.Account;
import com.nbsp.Dao.AccountDao;
import com.nbsp.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class Test01 {

    @Autowired
    private AccountDao ad;


    @Test
    public void Test(){
        List<Account> accounts = ad.FindAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
