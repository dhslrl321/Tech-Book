package org.example;

public class Money {

    private final long value;
    private Origin from;

    private Money(long value) {
        this.value = value;
    }

    public static Money of(long value) {
        return new Money(value);
    }

    public Money plus(Money target) {
        return new Money(value + target.value);
    }

    public Money minus(Money target) {
        return new Money(value - target.value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}