package com.example.lab7_673380301_0_sec1.strategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double originalPrice) {
        return originalPrice;
    }

    @Override
    public String getStrategyName() {
        return "ราคาปกติ (0%)";
    }
}
