package com.spring.examples.FirstExample;

public class HappyFortuneService implements IFortuneService{
    @Override
    public String getFortune() {
        return "Today is Your Lucky day!";
    }
}
