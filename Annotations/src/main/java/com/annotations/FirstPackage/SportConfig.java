package com.annotations.FirstPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.annotations.FirstPackage")
public class SportConfig {
    //define bean for our sad fortune service
    @Bean
    public IFortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    //define bean for swim coach and inject dependency
    @Bean
    public ICoach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }

}
