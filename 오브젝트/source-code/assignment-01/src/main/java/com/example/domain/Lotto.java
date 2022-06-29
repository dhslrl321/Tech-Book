package com.example.domain;

public class Lotto {

    Numbers numbers;
    int hitCount;

    private Lotto() {}

    private Lotto(Numbers numbers, int hitCount) {}

    private Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(Numbers numbers) {
        return new Lotto(numbers);
    }

    public void hit(Numbers provided) {
        hitCount = numbers.compare(provided);
    }

    public int getHitCount() {
        return hitCount;
    }
}
