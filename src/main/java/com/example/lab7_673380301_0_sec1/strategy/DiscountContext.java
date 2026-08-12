package com.example.lab7_673380301_0_sec1.strategy;

import com.example.lab7_673380301_0_sec1.model.Game;
import org.springframework.stereotype.Component;

@Component
public class DiscountContext {

    public DiscountStrategy getStrategy(String discountType) {
        if (discountType == null) {
            return new NoDiscountStrategy();
        }

        switch (discountType.toUpperCase()) {
            case "STUDENT":
                return new StudentDiscountStrategy();
            case "SEASONAL":
                return new SeasonalSaleStrategy();
            case "NONE":
            default:
                return new NoDiscountStrategy();
        }
    }

    public void applyDiscount(Game game) {
        if (game == null) return;
        
        DiscountStrategy strategy = getStrategy(game.getDiscountType());
        double price = game.getPrice() != null ? game.getPrice() : 0.0;
        
        game.setFinalPrice(strategy.calculateFinalPrice(price));
        game.setDiscountName(strategy.getStrategyName());
    }
}
