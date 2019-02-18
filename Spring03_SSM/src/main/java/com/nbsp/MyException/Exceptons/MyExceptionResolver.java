package com.nbsp.MyException.Exceptons;

import com.nbsp.MyException.MoneyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest Req, HttpServletResponse Resp, Object o, Exception exception) {

        ModelAndView modelAndView = new ModelAndView();
        String Msg=null;
        MoneyException me;
        if(exception instanceof MoneyException){
            me = (MoneyException) exception;
           Msg= exception.getMessage();
        }
        modelAndView.addObject("Msg",Msg);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
