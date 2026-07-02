package com.cognizant.forecasting;

public class Main {

    public static void main(String[] args) {

        double presentValue = 1000;
        double growthRate = 0.10;
        int years = 5;

        double futureValue = Forecast.predictValue(presentValue, growthRate, years);

        System.out.println("Present Value : " + presentValue);
        System.out.println("Growth Rate : " + (growthRate * 100) + "%");
        System.out.println("Years : " + years);
        System.out.println("Future Value : " + futureValue);

        System.out.println();
        System.out.println("Time Complexity : O(n)");
    }
}