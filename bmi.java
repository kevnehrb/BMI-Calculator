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
        double retValue = 0.00;
        final double engConst = 703;
        Double calcWeight = new Double(weight);
        Double calcHeight = new Double(height);
        if(english)
            retValue = ((calcWeight*engConst)/(calcHeight*calcHeight));
        else
            retValue = ((calcWeight)/(calcHeight*calcHeight));

        return df.format(retValue);
    }
}
