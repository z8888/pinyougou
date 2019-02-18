package com.nbsp.Service;


import com.nbsp.domain.Ssm;

import java.util.List;

public interface SsmService {
    // 查询所有

    List<Ssm> FindAll();

    // 查询单个
    Ssm  FindByid(Integer id);

    // 删除用户
    void  deleteByid(Integer id);

    // 更新用户
    void updateSsm(Ssm ssm);

    // 转账
    void Transaction(String name1, String name2, Integer money);


}
