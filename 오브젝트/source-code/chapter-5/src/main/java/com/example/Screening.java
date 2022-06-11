package com.example;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    /**
     * 메시지를 예매하라
     *
     * @param customer
     * @param audienceCount
     * @return
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        // 수신자의 의도를 표현하였다.
        return movie.calculateMovieFee(this).times(audienceCount); // 영화 금액을 계산하라
    }
}
