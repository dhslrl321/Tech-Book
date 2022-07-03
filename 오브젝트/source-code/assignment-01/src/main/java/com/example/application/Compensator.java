package com.example.application;

import com.example.domain.compensation.CompensationRuleSet;
import com.example.domain.compensation.Compensations;
import com.example.domain.lottery.Lotteries;
import com.example.domain.lottery.WinningNumber;
import java.util.List;

public class Compensator {

    private final WinningNumber winningNumber;
    private final CompensationRuleSet ruleSet;

    private Compensator(WinningNumber winningNumber, CompensationRuleSet ruleSet) {
        this.winningNumber = winningNumber;
        this.ruleSet = ruleSet;
    }

    public static Compensator of(WinningNumber winningNumber, CompensationRuleSet ruleSet) {
        return new Compensator(winningNumber, ruleSet);
    }

    public Compensations compensate(Lotteries lotteries) {
        List<Integer> hits = lotteries.getComparedHits(winningNumber);
        ruleSet.counting(hits);
        return ruleSet.toCompensations();
    }
}
