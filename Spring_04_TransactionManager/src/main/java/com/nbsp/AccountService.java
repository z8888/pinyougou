package com.nbsp;

import com.nbsp.Bean.Account;

import java.util.List;

public interface AccountService  {

    List<Account> FindAccountAll();

    void Translokigo(String user1, String user2, Float money);


}
