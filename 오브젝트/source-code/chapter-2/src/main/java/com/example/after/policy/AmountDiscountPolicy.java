package com.example.after.policy;

import com.example.after.domain.Money;
import com.example.after.domain.Screening;
import com.example.after.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {

    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition...conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
