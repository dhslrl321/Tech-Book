package com.wonit;

public abstract class BasicRatePolicy {
    abstract protected Money calculateCallFee(Call call);
}
