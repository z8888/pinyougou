package com.nbsp.Contrller;


import com.nbsp.Service.SsmService;
import com.nbsp.domain.Ssm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class SsmContrller {
    @Autowired
    private SsmService ssmService;

    @RequestMapping("findall")
    public ModelAndView FindAll(){
        try {
            ModelAndView amv = new ModelAndView();
            List<Ssm> ssms = ssmService.FindAll();
            amv.addObject("list",ssms);
            amv.setViewName("succees");
            return amv;
        }catch (Exception m){
           throw new RuntimeException();
        }
    }
    @RequestMapping("delete")
    public String ssmid(String ssmid){
        System.out.println("访问了");
       Integer id= Integer.parseInt(ssmid);
       ssmService.deleteByid(id);
        return "redirect:/user/findall";
    }

}
