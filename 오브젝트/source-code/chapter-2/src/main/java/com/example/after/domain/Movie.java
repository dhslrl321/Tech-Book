package com.example.after.domain;

import com.example.after.policy.DiscountPolicy;
import java.time.Duration;

public class Movie {
    private String title;
    private Duration durationTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration durationTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.durationTime = durationTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
