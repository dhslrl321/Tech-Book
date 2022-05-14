package com.example.advanced.specification;

public class AndCondition<FACTOR> implements Condition<FACTOR> {
    private final Condition<FACTOR> left;
    private final Condition<FACTOR> right;

    public AndCondition(Condition<FACTOR> left, Condition<FACTOR> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfy(FACTOR factor) {
        return left.isSatisfy(factor) &&
                right.isSatisfy(factor);
    }
}
