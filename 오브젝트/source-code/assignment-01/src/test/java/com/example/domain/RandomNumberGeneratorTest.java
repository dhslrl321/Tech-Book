package com.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.domain.lottery.Numbers;
import com.example.util.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    RandomNumberGenerator sut;

    @Test
    void 숫자_개수에_맞는_numbers_가_생성된다() {
        sut = new RandomNumberGenerator();

        Numbers actual = sut.generate(6);
        assertThat(actual.getSize()).isEqualTo(6);
    }
}