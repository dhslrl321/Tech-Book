package com.example.after.condition;

import com.example.after.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
