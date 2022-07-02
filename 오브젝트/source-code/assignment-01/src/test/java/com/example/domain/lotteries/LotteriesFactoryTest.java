package com.example.domain.lotteries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.domain.lottery.Lotteries;
import com.example.domain.lottery.LotteriesFactory;
import com.example.domain.value.Price;
import com.example.util.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LotteriesFactoryTest {
    private static final int UNIT_PRICE = 1000;
    private static final int LOTTERY_NUMBER_COUNT = 6;
    private static final int PROVIDED_PRICE = 14000;

    LotteriesFactory sut;

    Price unitPrice = Price.of(UNIT_PRICE);
    RandomNumberGenerator generator = mock(RandomNumberGenerator.class);

    @BeforeEach
    void setUp() {
        sut = new LotteriesFactory(LOTTERY_NUMBER_COUNT, unitPrice, generator);
    }

    @Test
    void 개수만큼_호출된다() {
        sut.createBy(Price.of(PROVIDED_PRICE));
        verify(generator, times(PROVIDED_PRICE / UNIT_PRICE)).generate(LOTTERY_NUMBER_COUNT);
    }

    @Test
    void 개수만큼_Lottery_가_생성된다() {
        Lotteries actual = sut.createBy(Price.of(PROVIDED_PRICE));
        assertThat(actual.size()).isEqualTo(14);
    }

    @Test
    void 당첨_번호를_넘기면_몇개가_맞았는지_반환한다() {

    }
}