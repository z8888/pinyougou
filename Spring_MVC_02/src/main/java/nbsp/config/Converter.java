package nbsp.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter implements org.springframework.core.convert.converter.Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("参数传递错误....");
        }

        DateFormat df=new SimpleDateFormat("yyyy-MM--dd");
        try {
            return    df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("转换异常.....");
        }

    }
}
