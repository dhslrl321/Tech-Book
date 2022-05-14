package com.example.advanced.specification;

@FunctionalInterface
public interface Condition<FACTOR> {
    boolean isSatisfy(FACTOR factor);

    default Condition<FACTOR> and(Condition<FACTOR> songNameCondition) {
        return new AndCondition<>(this, songNameCondition);
    };
}
