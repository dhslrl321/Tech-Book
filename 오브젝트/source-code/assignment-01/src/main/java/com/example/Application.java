package com.example;

import com.example.application.Compensator;
import com.example.application.YieldRateCalculator;
import com.example.domain.compensation.CompensationRule;
import com.example.domain.compensation.CompensationRuleSet;
import com.example.domain.compensation.Compensations;
import com.example.domain.lottery.Lotteries;
import com.example.domain.lottery.LotteriesFactory;
import com.example.domain.lottery.WinningNumber;
import com.example.domain.lottery.WinningNumberFactory;
import com.example.domain.value.Price;
import com.example.util.ConsoleReader;
import com.example.util.ConsoleWriter;
import com.example.util.RandomNumberGenerator;
import java.util.LinkedList;

public class Application {

    private static final WinningNumberFactory winningNumberFactory = new WinningNumberFactory();
    private static final LotteriesFactory lotteriesFactory = new LotteriesFactory(6, Price.of(1000), new RandomNumberGenerator());

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();


        writer.printIntro();
        String inputMoney = reader.readLine();
        writer.printBuyingMessage(Integer.parseInt(inputMoney));

        Lotteries lotteries = lotteriesFactory.createBy(
                Price.of(Integer.parseInt(inputMoney)));

        writer.printBoughtLotteries(lotteries);
        writer.printLastWinningNumber();
        String lastWinningNumber = reader.readLine();

        CompensationRule rule1 = CompensationRule.of(Price.of(5_000), 3);
        CompensationRule rule2 = CompensationRule.of(Price.of(50_000), 4);
        CompensationRule rule3 = CompensationRule.of(Price.of(1_500_000), 5);
        CompensationRule rule4 = CompensationRule.of(Price.of(200_000_000), 6);

        CompensationRuleSet ruleSet = CompensationRuleSet.empty();

        ruleSet.addRule(rule1);
        ruleSet.addRule(rule2);
        ruleSet.addRule(rule3);
        ruleSet.addRule(rule4);

        WinningNumber winningNumber = winningNumberFactory.create(lastWinningNumber);

        Compensator compensator = Compensator.of(winningNumber, ruleSet);

        Compensations compensations = compensator.compensate(lotteries);

        writer.printCompensationScore(compensations);

        YieldRateCalculator yieldRateCalculator = YieldRateCalculator.create();
        double yieldRate = yieldRateCalculator.calculate(Price.of(Integer.parseInt(inputMoney)), compensations);

        System.out.println("yieldRate = " + yieldRate);
    }
}
