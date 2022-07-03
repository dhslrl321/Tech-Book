package com.example.domain.compensation;

import com.example.domain.value.Price;

public class Compensation {

    private final Price rewardPrice;
    private final int baseCount;
    private final int actualCount;

    private Compensation(Price rewardPrice, int baseCount, int actualCount) {
        this.rewardPrice = rewardPrice;
        this.baseCount = baseCount;
        this.actualCount = actualCount;
    }

    public static Compensation of(Price rewardPrice, int baseCount, int actualCount) {
        return new Compensation(rewardPrice, baseCount, actualCount);
    }

    public int getActualCount() {
        return actualCount;
    }

    public Price getRewardPrice() {
        return rewardPrice;
    }

    public int getBaseCount() {
        return baseCount;
    }
}
