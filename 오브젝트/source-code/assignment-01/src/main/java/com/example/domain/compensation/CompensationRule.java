package com.example.domain.compensation;

import com.example.domain.value.Price;

public class CompensationRule {

    private final Price price;
    private final int baseCount;
    private int actualCount = 0;

    private CompensationRule(Price price, int baseCount) {
        this.price = price;
        this.baseCount = baseCount;
    }

    public static CompensationRule of(Price price, int baseCount) {
        return new CompensationRule(price, baseCount);
    }

    public boolean isSatisfiedBy(int providedBaseCount) {
        return baseCount == providedBaseCount;
    }

    public void plusActualCount() {
        actualCount++;
    }

    public int getActualCount() {
        return actualCount;
    }

    public Compensation toCompensation() {
        return Compensation.of(price, baseCount, actualCount);
    }
}
