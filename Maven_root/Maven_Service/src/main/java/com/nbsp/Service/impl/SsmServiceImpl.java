package com.nbsp.Service.impl;

import com.nbsp.Dao.SsmDao;
import com.nbsp.Service.SsmService;
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


            sd.Transaction(name1,name2,money);
    }


}
