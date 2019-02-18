package com.nbsp.Dao;

import com.nbsp.Domain.Account;

import java.util.List;

public interface AccountDao {


    List<Account> FindAccountAll();

    void Translokigo(String user1,String user2,Float money);


}
