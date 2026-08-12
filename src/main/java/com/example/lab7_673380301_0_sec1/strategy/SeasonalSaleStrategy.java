package com.example.lab7_673380301_0_sec1.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy {

    @Override
    public double calculateFinalPrice(double originalPrice) {
        return originalPrice * 0.80; // 20% discount
    }

    @Override
    public String getStrategyName() {
        return "ส่วนลดเทศกาล (20%)";
    }
}
