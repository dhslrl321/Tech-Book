package com.example.domain.lottery;

import com.example.domain.value.Price;
import com.example.util.RandomNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteriesFactory {

    private final int lotteryNumberCount;
    private final Price unitPrice;
    private final RandomNumberGenerator generator;

    public LotteriesFactory(int lotteryNumberCount, Price unitPrice, RandomNumberGenerator generator) {
        this.lotteryNumberCount = lotteryNumberCount;
        this.unitPrice = unitPrice;
        this.generator = generator;
    }

    public Lotteries createBy(Price price) {
        List<Lottery> collect = IntStream
                .range(0, getLotteryCount(price))
                .mapToObj(i -> generateLottery())
                .collect(Collectors.toList());

        return Lotteries.from(collect);
    }

    private Lottery generateLottery() {
        return Lottery.from(generator.generate(lotteryNumberCount));
    }

    private int getLotteryCount(Price provided) {
        return (int) provided.get() / (int) unitPrice.get();
    }
}
