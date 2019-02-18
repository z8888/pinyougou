package com.nbsp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({AboutDateSourceConfig.class})
@ComponentScan("com.nbsp")
@PropertySource("jdbcConfig.properties")
public class SpringConfig {


}
