package com.example.domain.compensation;

import com.example.domain.value.Price;
import java.util.List;

public class Compensations {
    private final List<Compensation> compensations;

    public Compensations(List<Compensation> compensations) {
        this.compensations = compensations;
    }

    public static Compensations from(List<Compensation> compensations) {
        return new Compensations(compensations);
    }

    public int size() {
        return compensations.size();
    }

    public Price getTotalRewardPrice() {
        Price rewardPrice = Price.of(0);
        for (Compensation compensation : compensations) {
            rewardPrice = rewardPrice.plus(
                    Price.of(compensation.getRewardPrice().get() * compensation.getActualCount()));
        }
        return rewardPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Compensation compensation : compensations) {
            sb.append(String.format("%d 개 일치 (%d원)- %d 개", compensation.getBaseCount(), compensation.getRewardPrice().get(), compensation.getActualCount()));
        }
        return sb.toString();
    }
}
