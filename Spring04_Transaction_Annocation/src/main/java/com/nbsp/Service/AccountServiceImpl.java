package com.nbsp.Service;

import com.nbsp.domian.Account;
import com.nbsp.Dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("accountServiceImpl")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS )
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountdao;

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS )
    @Override
    public List<Account> FindAccountAll() {
        System.out.println(accountdao);
        return accountdao.FindAccountAll();
    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED )
    @Override
    public void Translokigo(String user1, String user2, Float money) {

        accountdao.Translokigo(user1,user2,money);

    }
}
