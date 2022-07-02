package com.example.domain.compensation;

import com.example.domain.lottery.Numbers;

public class WinningNumber {
    private final Numbers numbers;

    public WinningNumber(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
