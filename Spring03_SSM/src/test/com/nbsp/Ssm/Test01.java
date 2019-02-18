package nbsp.Ssm;


import com.nbsp.Service.SsmService;
import com.nbsp.domain.Account;
import com.nbsp.domain.Ssm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springConfig/ApplicationContext.xml")
public class Test01 {
    @Autowired
   private SsmService ssmService;

    @Test
    public void findAll(){

        List<Ssm> ssms = ssmService.FindAll();
        for (Ssm ssm : ssms) {
            System.out.println(ssm);
        }
    }
/*@Autowired
    private SsmDao sd;
    @Test
    public void find(){
        System.out.println(sd);
        List<Ssm> ssms = sd.FindAll();
        for (Ssm ssm : ssms) {
            System.out.println(ssm);
        }
    }*/

public void FindAccount(){
    List<Account> accounts = ssmService.Account();
    for (Account account : accounts) {
        System.out.println(account);
    }
}
}
