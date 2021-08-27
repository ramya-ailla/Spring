package com.spring.AOPAroundAdvicedemo.Service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() {
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return Fortune
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripwire) {
        if(tripwire){
            throw new RuntimeException("Major Accident!...Heavy traffic Jam");
        }
        return getFortune();
    }
}
