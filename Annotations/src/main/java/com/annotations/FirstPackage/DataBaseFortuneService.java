package com.annotations.FirstPackage;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFortuneService implements IFortuneService{
    @Override
    public String getFortune() {
        return "DB fortune Service";
    }
}
