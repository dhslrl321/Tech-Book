package com.example.advanced;

public class And implements Specification {
    private Specification left;
    private Specification right;

    public And(Specification left, Specification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(Factor factor) {
        return left.isSatisfiedBy(factor) &&
                right.isSatisfiedBy(factor);
    }
}
