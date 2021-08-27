package com.annotations.FirstPackage;

public class SadFortuneService implements IFortuneService{
    @Override
    public String getFortune() {
        return "Today is your unlucky day. you will be sad";
    }
}
