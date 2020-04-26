package com.example.prog5;

import java.text.DecimalFormat;

public class bmi{
    private int weight, height;
    private boolean english;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public bmi(int weight, int height, boolean english){
        this.weight = weight;
        this.height = height;
        this.english = english;
    }

    public String bmiCalculator(){
        double retValue = 0;
        if(english)
            retValue = (weight*703)/(height*height);
        else
            retValue = weight/(height*height);

        return df.format(retValue);
    }
}
