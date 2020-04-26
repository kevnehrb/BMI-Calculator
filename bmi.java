package com.example.prog5;

import java.text.DecimalFormat;

public class bmi{
    private double weight, height;
    private boolean english;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public bmi(double weight, double height, boolean english){
        this.weight = weight;
        this.height = height;
        this.english = english;
    }

    public String bmiCalculator(){
        double retValue = 0.00;
        final double engConst = 703.0;
        if(english)
            retValue = ((weight*engConst)/(height*height));
        else
            retValue = ((weight)/(height*height));

        return df.format(retValue);
    }
}
