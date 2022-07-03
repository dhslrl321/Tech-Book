package com.example.util;

import com.example.domain.compensation.Compensations;
import com.example.domain.lottery.Lotteries;

public class ConsoleWriter {
    public void printIntro() {
        System.out.println("구매 금액을 입력해주세요");
    }

    public void printBuyingMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    // TODO Presenter Layer 가 비즈니스를 아는게 맞는가
    public void printBoughtLotteries(Lotteries lotteries) {
        System.out.println(lotteries.toString());
    }

    public void printLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력하세요");
    }

    public void printCompensationScore(Compensations compensations) {
        System.out.println(compensations.toString());
    }
}
