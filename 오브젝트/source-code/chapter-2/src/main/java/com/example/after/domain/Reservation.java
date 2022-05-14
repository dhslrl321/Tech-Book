package com.example.after.domain;

public class Reservation {

    private final Customer customer;
    private final Screening screening;
    private final Money fee;
    private final int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
