package com.nbsp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("springWeb")
@RequestMapping(path = "user")
public class SpringWeb {


    @RequestMapping(path = "save")
    public String save(){
        System.out.println("跳转了");
        return "save";
    }


}
