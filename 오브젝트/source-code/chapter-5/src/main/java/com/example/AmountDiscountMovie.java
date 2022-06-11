package com.example;

public class AmountDiscountMovie extends Movie {

    @Override
    protected Money calculateDiscountAmount() {
        return null;
    }

    @Override
    public Money calculateMovieFee(Screening screening) {
        return Money.wons(123);
    }
}
