package com.example.domain.compensation;

import com.example.domain.lottery.Lotteries;
import java.util.List;

public class Compensator {

    private final WinningNumber winningNumber;
    private final CompensationRuleSet ruleSet;

    public Compensator(WinningNumber winningNumber, CompensationRuleSet ruleSet) {
        this.winningNumber = winningNumber;
        this.ruleSet = ruleSet;
    }

    public static Compensator of(WinningNumber winningNumber, CompensationRuleSet ruleSet) {
        return new Compensator(winningNumber, ruleSet);
    }

    public List<Compensation> compensate(Lotteries lotteries) {
        List<Integer> hits = lotteries.getComparedHits(winningNumber);
        ruleSet.counting(hits);
        return null;
    }
}
