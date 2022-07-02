package com.example.domain.value;

public class Price {
    private final Long value;

    public Price(long value) {
        this.value = value;
    }

    public static Price of(long value) {
        return new Price(value);
    }

    public long get() {
        return value;
    }
}
