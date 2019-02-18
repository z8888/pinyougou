package com.nbsp.domian.Dao;


import com.nbsp.domian.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("accountDaoImpl")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    @Override
    public List<Account> FindAccountAll() {

        return super.getJdbcTemplate().query("select * from account " ,new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public void Translokigo(String user1, String user2, Float money) {
        super.getJdbcTemplate().update("update account set money=(money - ?) where name=?",money,user1);
       // int i=1/0;
        super.getJdbcTemplate().update("update account set money=(money + ?) where name=?",money,user2);

    }
}
