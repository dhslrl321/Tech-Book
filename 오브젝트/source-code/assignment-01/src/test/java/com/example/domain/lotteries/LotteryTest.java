package com.example.domain.lotteries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.domain.lottery.Lottery;
import com.example.domain.lottery.Numbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LotteryTest {

    public static final int SAME_COUNT = 4;
    @InjectMocks
    Lottery sut;

    @Mock
    Numbers numbers;

    @Test
    void 정답과_로또를_비교해서_당첨_숫자_개수를_계산한다() {
        Numbers answer = mock(Numbers.class);
        given(numbers.compare(answer)).willReturn(SAME_COUNT);

        int actual = sut.hit(answer);

        assertThat(actual).isEqualTo(SAME_COUNT);
    }
}