package com.spring.AOP.pointcutdeclarationsdemo;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//pure java configuration
@Configuration
@EnableAspectJAutoProxy //Spring AOP proxy Support
@ComponentScan("com.spring.AOP.pointcutdeclarationsdemo")
public class DemoConfig {
}
