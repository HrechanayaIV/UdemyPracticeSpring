package com.luv2code.springdemoannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@ComponentScan("com.luv2code.springdemoannotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    // add support to resolve ${...} properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceHolderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }

    //define bean for our sad fortune
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    //define bean for our swimming coach and inject dependency
    //bean id is the same as name of method id = swimmingCoach
    @Bean
    public Coach swimmingCoach(){
        Coach mySwimCoach = new SwimmingCoach(sadFortuneService());
        return mySwimCoach;
    }
}
