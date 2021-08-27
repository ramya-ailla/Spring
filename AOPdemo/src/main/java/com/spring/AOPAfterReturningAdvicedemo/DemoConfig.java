package com.spring.AOPAfterReturningAdvicedemo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//pure java configuration
@Configuration
@EnableAspectJAutoProxy //Spring AOP proxy Support
@ComponentScan("com.spring.AOPAfterReturningAspectdemo")
public class DemoConfig {
}
