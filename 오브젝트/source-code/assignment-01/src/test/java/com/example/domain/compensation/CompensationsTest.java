package com.example.domain.compensation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.domain.value.Price;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompensationsTest {
    Compensations sut;

    @BeforeEach
    void setUp() {
        List<Compensation> compensations = stubbingCompensations();
        sut = Compensations.from(compensations);
    }

    @Test
    void 총_수익금을_알_수_있다() {
        Price actual = sut.getTotalRewardPrice();

        assertThat(actual.get()).isEqualTo(22000);
    }

    private List<Compensation> stubbingCompensations() {
        List<Compensation> list = new ArrayList<>();
        list.add(Compensation.of(Price.of(100), 3, 0));
        list.add(Compensation.of(Price.of(1000), 4, 2));
        list.add(Compensation.of(Price.of(10000), 5, 2));
        return list;
    }
}