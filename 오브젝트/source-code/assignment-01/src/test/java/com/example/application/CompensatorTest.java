package com.example.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.application.Compensator;
import com.example.domain.compensation.Compensation;
import com.example.domain.compensation.CompensationRuleSet;
import com.example.domain.compensation.Compensations;
import com.example.domain.lottery.Lotteries;
import com.example.domain.lottery.WinningNumber;
import com.example.domain.value.Price;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CompensatorTest {

    @InjectMocks
    Compensator sut;

    @Mock
    WinningNumber winningNumber;
    @Mock
    CompensationRuleSet ruleSet;

    @BeforeEach
    void setUp() {
        sut = Compensator.of(winningNumber, ruleSet);
    }

    @Test
    void RuleSet_만큼_보상이_나온다() {
        Lotteries lotteries = mock(Lotteries.class);
        Compensations compensations = getCompensations();

        given(ruleSet.toCompensations()).willReturn(compensations);

        Compensations actual = sut.compensate(lotteries);

        assertThat(actual.size()).isEqualTo(3);
    }

    private Compensations getCompensations() {
        List<Compensation> compensations = new ArrayList<>();
        compensations.add(Compensation.of(Price.of(100), 1, 1));
        compensations.add(Compensation.of(Price.of(1000), 2, 1));
        compensations.add(Compensation.of(Price.of(10000), 2, 1));
        return Compensations.from(compensations);
    }
}