package com.nbsp.domian.Service;

import com.nbsp.domian.Account;

import java.util.List;

public interface AccountService  {

    List<Account> FindAccountAll();

    void Translokigo(String user1, String user2, Float money);


}
