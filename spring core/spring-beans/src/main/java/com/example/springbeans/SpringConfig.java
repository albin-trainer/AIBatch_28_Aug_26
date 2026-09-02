package com.example.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//this class replaces the beans.xml
@Configuration
@ComponentScan(basePackages = "com.example.springbeans")
public class SpringConfig {
   /* @Bean
    public AccountServiceImpl getAccService(){
        return new AccountServiceImpl();
    }
    @Bean
    @Primary
    public CurrentAccountService getCurrentAcc(){
        return new CurrentAccountService();
    }*/
    @Bean("accountController")
    public AccountController getController(){
        return new AccountController();
    }
}
