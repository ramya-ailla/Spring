package com.annotations.FirstPackage;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements IFortuneService{
    private String[] data = {
        "Beware of wolf in Sheep's Clothing",
            "Diligence is mother of good luck",
            "Journey is the reward"
    };
    private Random myRandom = new Random();
    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
