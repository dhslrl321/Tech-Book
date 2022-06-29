package com.example.domain;

public class Numbers {

    private final int[] integers;

    private Numbers(int[] integers) {
        this.integers = integers;
    }

    public static Numbers of(int[] provided) {
        return new Numbers(provided);
    }

    public int compare(Numbers answer) {
        int count = 0;
        for (int integer : integers) {
            for (int i : answer.integers) {
                if (integer == i) {
                    count++;
                }
            }
        }
        return count;
    }
}
