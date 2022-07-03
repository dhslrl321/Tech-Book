package com.example.domain.lottery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    Lotteries sut;

    WinningNumber winningNumber = mock(WinningNumber.class);
    Numbers numbers = mock(Numbers.class);

    @BeforeEach
    void setUp() {
        Lottery lottery1 = mock(Lottery.class);
        Lottery lottery2 = mock(Lottery.class);
        given(lottery1.hit(winningNumber.getNumbers())).willReturn(1);
        given(lottery2.hit(winningNumber.getNumbers())).willReturn(0);

        sut = Lotteries.from(List.of(lottery1, lottery2));
    }

    @Test
    void 갯수만큼_생성된다() {
        assertThat(sut.size()).isEqualTo(2);
    }

    @Test
    void 보유한_로또_수와_당첨된_수_카운트와_같다() {
        given(winningNumber.getNumbers()).willReturn(numbers);

        List<Integer> actual = sut.getComparedHits(winningNumber);

        assertThat(actual.size()).isEqualTo(sut.size());
    }
}