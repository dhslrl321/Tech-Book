package com.example.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.domain.Lotto;
import com.example.domain.Numbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LottoTest {

    @InjectMocks
    Lotto sut;

    @Mock
    Numbers numbers;

    @Test
    void name() {
        Numbers answer = mock(Numbers.class);
        given(numbers.compare(answer)).willReturn(4);

        sut.hit(answer);

        assertThat(sut.getHitCount()).isEqualTo(4);
    }

    @Test
    void name2() {
        Numbers answer = mock(Numbers.class);
        given(numbers.compare(answer)).willReturn(0);

        sut.hit(answer);

        assertThat(sut.getHitCount()).isEqualTo(0);
    }
}