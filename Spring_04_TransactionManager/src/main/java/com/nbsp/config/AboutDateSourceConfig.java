package com.nbsp.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


public class AboutDateSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String passworld;

    @Bean
    public DataSource getDataSource(){
        System.out.println(driver+url+username+passworld);

        ComboPooledDataSource cdp = new ComboPooledDataSource();
        try {
            cdp.setDriverClass(driver);
            cdp.setJdbcUrl(url);
            cdp.setUser(username);
            cdp.setPassword(passworld);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return cdp;
    }
    @Bean
    public JdbcTemplate getjdbctemplate( DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
