package com.example.domain.lotteries;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.domain.lottery.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumbersTest {

    private static final int[] PROVIDED = {1, 2, 3, 4, 5, 6};

    private static final int[] ALL_SAME = {1, 2, 3, 4, 5, 6};
    private static final int[] SAME_1 = {1, 9, 9, 9, 9, 9};
    private static final int[] SAME_2 = {1, 9, 9, 9, 9, 2};
    private static final int[] UN_ORDERED = {9, 2, 7, 5, 1, 3};

    Numbers sut;

    @BeforeEach
    void setUp() {
        sut = Numbers.createWithSort(PROVIDED);
    }

    @Test
    void 숫자가_모두_동일하면_동일한_개수만큼_반환한다() {
        Numbers newNumber = Numbers.createWithSort(ALL_SAME);

        assertThat(sut.compare(newNumber)).isEqualTo(6);
    }

    @Test
    void 하나만_동일하다면_1만_반환한다() {
        Numbers newNumber = Numbers.createWithSort(SAME_1);

        assertThat(sut.compare(newNumber)).isEqualTo(1);
    }

    @Test
    void 두개가_동일하다면_2만_반환한다() {
        Numbers newNumber = Numbers.createWithSort(SAME_2);

        assertThat(sut.compare(newNumber)).isEqualTo(2);
    }

    @Test
    void 숫자는_항상_정렬된다() {
        Numbers sut = Numbers.createWithSort(UN_ORDERED);
        int actual = sut.getItemByIndex(0);

        assertThat(actual).isEqualTo(1);
    }
}