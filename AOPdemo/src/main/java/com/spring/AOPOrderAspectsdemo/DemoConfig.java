package com.spring.AOPOrderAspectsdemo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//pure java configuration
@Configuration
@EnableAspectJAutoProxy //Spring AOP proxy Support
@ComponentScan("com.spring.AOPOrderAspectsdemo")
public class DemoConfig {
}
