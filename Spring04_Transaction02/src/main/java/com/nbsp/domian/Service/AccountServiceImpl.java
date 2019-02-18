package com.nbsp.domian.Service;

import com.nbsp.domian.Account;

import com.nbsp.domian.Dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountdao;
    public void setAccountdao(AccountDao accountdao) {
        this.accountdao = accountdao;
    }

    @Override
    public List<Account> FindAccountAll() {
        System.out.println(accountdao);
        return accountdao.FindAccountAll();
    }

    @Override
    public void Translokigo(String user1, String user2, Float money) {

        accountdao.Translokigo(user1,user2,money);

    }
}
