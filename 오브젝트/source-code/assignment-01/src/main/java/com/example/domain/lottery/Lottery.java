package com.example.domain.lottery;

public class Lottery {

    private final Numbers numbers;

    private Lottery(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Lottery from(Numbers numbers) {
        return new Lottery(numbers);
    }

    public int hit(Numbers provided) {
        return numbers.compare(provided);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
