package com.example.domain.lottery;

public class WinningNumber {
    private final Numbers numbers;

    private WinningNumber(Numbers numbers) {
        this.numbers = numbers;
    }

    public static WinningNumber from(Numbers numbers) {
        return new WinningNumber(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
