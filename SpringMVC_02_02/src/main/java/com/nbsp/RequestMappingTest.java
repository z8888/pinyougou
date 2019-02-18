package com.nbsp;

import com.nbsp.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("requestMappingTest")
@RequestMapping("user")
public class RequestMappingTest {

    @RequestMapping("forward")
    public String forward(Model model){
        System.out.println("FindAccount。。。。");
        User user=new User();
        user.setAge(18);
        user.setName("呵呵");
        user.setSex("男");
        model.addAttribute("user",user);
       // return "forward:/WEB-INF/pages/success.jsp";
        return "success";
    }

    @RequestMapping("redirect")
    public String redirect(){
        System.out.println("redirect。。。。");
       // return "redirect:/redirect.jsp";
        return "success";
    }
}
