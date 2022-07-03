package com.example.domain.value;

public class Price {
    private final Long value;

    public Price(long value) {
        this.value = value;
    }

    public static Price of(long value) {
        return new Price(value);
    }

    public Price plus(Price price) {

        return Price.of(price.value + value);
    }

    public long get() {
        return value;
    }
}
