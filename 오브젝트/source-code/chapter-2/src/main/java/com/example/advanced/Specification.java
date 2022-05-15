package com.example.advanced;

public interface Specification<FACTOR> {
    boolean isSatisfiedBy(FACTOR f);

    default Specification and(Specification ageSpec) {
        return new And(this, ageSpec);
    };
}
