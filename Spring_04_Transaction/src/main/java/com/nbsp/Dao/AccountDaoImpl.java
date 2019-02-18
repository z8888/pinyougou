package com.nbsp.Dao;


import com.nbsp.Bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jp;

    public void setJp(JdbcTemplate jp) {
        this.jp = jp;
    }

    @Override
    public List<Account> FindAccountAll() {

        return jp.query("select * from account " ,new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public void Translokigo(String user1, String user2, Float money) {
        jp.update("update account set money=(money - ?) where name=?",money,user1);
        jp.update("update account set money=(money + ?) where name=?",money,user2);

    }
}
