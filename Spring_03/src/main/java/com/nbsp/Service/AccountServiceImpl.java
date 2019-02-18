package com.nbsp.Service;

import com.nbsp.Dao.AccountDao;
import com.nbsp.domian.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountdao;

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
