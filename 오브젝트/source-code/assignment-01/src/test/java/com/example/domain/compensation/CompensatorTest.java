package com.example.domain.compensation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.example.domain.compensation.Compensator;
import com.example.domain.lottery.Lotteries;
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

        List<Compensation> actual = sut.compensate(lotteries);
        
        assertThat(actual.size()).isEqualTo(5);
    }
}