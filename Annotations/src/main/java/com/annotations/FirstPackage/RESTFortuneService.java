package com.annotations.FirstPackage;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements IFortuneService{
    @Override
    public String getFortune() {
        return "REST fortune Service";
    }
}
