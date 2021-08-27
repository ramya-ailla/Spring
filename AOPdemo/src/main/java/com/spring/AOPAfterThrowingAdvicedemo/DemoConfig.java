package com.spring.AOPAfterThrowingAdvicedemo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//pure java configuration
@Configuration
@EnableAspectJAutoProxy //Spring AOP proxy Support
@ComponentScan("com.spring.AOPAfterThrowingAdvicedemo")
public class DemoConfig {
}
