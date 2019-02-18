package com.nbsp.Service.impl;

import com.nbsp.Dao.SsmDao;
import com.nbsp.MyException.MoneyException;
import com.nbsp.Service.SsmService;
import com.nbsp.domain.Account;
import com.nbsp.domain.Ssm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ssmServiceImpl")
@Transactional
public class SsmServiceImpl implements SsmService {

    @Autowired
    private SsmDao sd;

    @Override
    public List<Ssm> FindAll() {
        //int i=1/0;
        return sd.FindAll();
    }

    @Override
    public Ssm FindByid(Integer id) {
        return sd.FindByid(id);
    }

    @Override
    public void deleteByid(Integer id) {
            sd.deleteByid(id);
    }

    @Override
    public void updateSsm(Ssm ssm) {
            sd.updateSsm(ssm);
    }

    @Override
    public void Transaction(String name1, String name2, Integer money) {
        if(name1==null||"".equals(name1)){
            throw new MoneyException("转账放不存在");
        }
        if(name2==null||"".equals(name2)){
            throw new MoneyException("收钱方不存在");
        }

            sd.Transaction(name1,name2,money);
    }

    @Override
    public List<Account> Account() {
        return sd.FindAccount();
    }

}
