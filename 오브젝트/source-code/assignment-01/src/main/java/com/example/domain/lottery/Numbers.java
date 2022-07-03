package com.example.domain.lottery;

import java.util.Arrays;

public class Numbers {

    private final int[] integers;

    private Numbers(int[] integers) {
        this.integers = integers;
    }

    public static Numbers createWithSort(int[] provided) {
        Arrays.sort(provided);
        return new Numbers(provided);
    }

    public int compare(Numbers answer) {
        return (int) Arrays.stream(integers)
                .filter(i -> isSameNumber(answer, i))
                .count();
    }

    public int getSize() {
        return integers.length;
    }

    public int getItemByIndex(int i) {
        return integers[i];
    }

    @Override
    public String toString() {
        return Arrays.toString(integers);
    }

    private boolean isSameNumber(Numbers answer, int i) {
        return Arrays.binarySearch(answer.integers, i) >= 0;
    }
}
