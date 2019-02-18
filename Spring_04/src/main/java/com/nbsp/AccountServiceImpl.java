package com.nbsp;

import com.nbsp.Dao.AccountDao;
import com.nbsp.Domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountdao;

  /*  @Autowired
    private Transaction tr;
*/


    @Override
    public List<Account> FindAccountAll() {

        return accountdao.FindAccountAll();
    }

    @Override
    public void Translokigo(String user1, String user2, Float money) {
        /*try {
            tr.beginTransaction();
            //int i=1/0;
            accountdao.Translokigo(user1,user2,money);
            tr.commit();
        }catch (Throwable t){
            tr.rollback();
            t.printStackTrace();
        }finally {
            tr.release();
        }*/

        accountdao.Translokigo(user1,user2,money);

    }
}
