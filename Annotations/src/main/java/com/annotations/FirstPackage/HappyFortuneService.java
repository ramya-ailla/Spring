package com.annotations.FirstPackage;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements IFortuneService{
    @Override
    public String getFortune() {
        return "Today is your lucky day";
    }
}
