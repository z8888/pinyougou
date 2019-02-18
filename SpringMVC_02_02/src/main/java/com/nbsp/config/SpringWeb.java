package com.nbsp.config;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("springWeb")
@RequestMapping(path = "user")
public class SpringWeb {


  /*  @RequestMapping(path = "save")
    public String save(User user){
        System.out.println("跳转了");
        System.out.println(user);
        return "succ";
    }

    @RequestMapping(path = "arr")
    public String arr(Integer [] arr){
        System.out.println("跳转了");
        System.out.println(Arrays.toString(arr));
        return "succ";
    }

    @RequestMapping(path = "list")
    public String list(User map){
        System.out.println("跳转了");
        System.out.println("list:"+map);
        return "succ";
    }*/

    @RequestMapping(path = "toDate")
    public String toDate(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("跳转了");
        System.out.println("req:"+req);
        System.out.println("resp:"+resp);

        return "succ";
    }

}
