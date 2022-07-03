package com.example.domain.lottery;

public class WinningNumberFactory {
    public WinningNumber create(String string) {
        String s = string.replaceAll(" ", "");
        String[] s1 = s.split(",");
        int[] integers = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            integers[i] = Integer.parseInt(s1[i]);
        }
        return WinningNumber.from(Numbers.createWithSort(integers));
    }
}
