package com.example.application;

import com.example.domain.compensation.Compensations;
import com.example.domain.value.Price;

public class YieldRateCalculator {

    public static YieldRateCalculator create() {
        return new YieldRateCalculator();
    }

    public double calculate(Price totalPrice, Compensations compensations) {
        double total = (double) totalPrice.get();
        double reward = compensations.getTotalRewardPrice().get();
        return Math.round((reward / total) * 100) / 100.0;
    }
}
