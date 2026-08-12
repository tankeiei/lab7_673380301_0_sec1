package com.example.lab7_673380301_0_sec1.strategy;

public class StudentDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double originalPrice) {
        return originalPrice * 0.90; // 10% discount
    }

    @Override
    public String getStrategyName() {
        return "ส่วนลดนักศึกษา (10%)";
    }
}
