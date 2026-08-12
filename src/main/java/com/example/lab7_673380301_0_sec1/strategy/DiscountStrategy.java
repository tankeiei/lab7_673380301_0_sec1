package com.example.lab7_673380301_0_sec1.strategy;

public interface DiscountStrategy {
    double calculateFinalPrice(double originalPrice);
    String getStrategyName();
}
