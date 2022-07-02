package com.example.domain.compensation;

import com.example.domain.value.Price;

public class Compensation {

    private final Price price;
    private final int baseCount;
    private final int actualCount;

    private Compensation(Price price, int baseCount, int actualCount) {
        this.price = price;
        this.baseCount = baseCount;
        this.actualCount = actualCount;
    }

    public static Compensation of(Price price, int baseCount, int actualCount) {
        return new Compensation(price, baseCount, actualCount);
    }

    public int getActualCount() {
        return actualCount;
    }

    public Price getRewardPrice() {
        return price;
    }

    public int getBaseCount() {
        return baseCount;
    }
}
