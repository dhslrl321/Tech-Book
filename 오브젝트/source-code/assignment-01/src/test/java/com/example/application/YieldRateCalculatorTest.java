package com.example.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.domain.compensation.Compensation;
import com.example.domain.compensation.Compensations;
import com.example.domain.value.Price;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YieldRateCalculatorTest {
    YieldRateCalculator sut;

    @BeforeEach
    void setUp() {
        sut = YieldRateCalculator.create();
    }

    @Test
    void name() {
        Compensations compensations = mock(Compensations.class);
        given(compensations.getTotalRewardPrice()).willReturn(Price.of(5000));
        Price totalPrice = Price.of(14000);

        double actual = sut.calculate(totalPrice, compensations);

        assertThat(actual).isEqualTo(0.36);
    }
}