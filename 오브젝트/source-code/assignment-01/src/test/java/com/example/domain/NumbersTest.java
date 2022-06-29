package com.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumbersTest {

    public static final int[] PROVIDED = {1, 2, 3, 4, 5, 6};

    public static final int[] ALL_SAME = {1, 2, 3, 4, 5, 6};
    public static final int[] DIFF_1 = {1, 9, 9, 9, 9, 9};
    public static final int[] DIFF_2 = {1, 9, 9, 9, 9, 2};
    Numbers sut;

    @BeforeEach
    void setUp() {
        sut = Numbers.of(PROVIDED);
    }

    @Test
    void name() {
        Numbers newNumber = Numbers.of(ALL_SAME);

        assertThat(sut.compare(newNumber)).isEqualTo(6);
    }

    @Test
    void name2() {
        Numbers newNumber = Numbers.of(DIFF_1);

        assertThat(sut.compare(newNumber)).isEqualTo(1);
    }

    @Test
    void name3() {
        Numbers newNumber = Numbers.of(DIFF_2);

        assertThat(sut.compare(newNumber)).isEqualTo(2);
    }
}