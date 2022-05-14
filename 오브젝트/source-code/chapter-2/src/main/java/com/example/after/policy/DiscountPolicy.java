package com.example.after.policy;

import com.example.after.domain.Money;
import com.example.after.domain.Screening;
import com.example.after.condition.DiscountCondition;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
