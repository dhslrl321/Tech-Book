package com.example.domain.lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotteries {

    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries from(List<Lottery> lotteries) {
        return new Lotteries(lotteries);
    }

    public int size() {
        return lotteries.size();
    }

    public List<Integer> getComparedHits(WinningNumber winningNumber) {
        List<Integer> hits = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            int hit = lottery.hit(winningNumber.getNumbers());
            hits.add(hit);
        }

        return hits;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lottery lottery : lotteries) {
            sb.append(lottery.toString() + "\n");
        }
        return sb.toString();
    }
}
