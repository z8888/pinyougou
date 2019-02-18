package com.nbsp.domian.Dao;

import com.nbsp.domian.Account;

import java.util.List;

public interface AccountDao {


    List<Account> FindAccountAll();

    void Translokigo(String user1, String user2, Float money);


}
