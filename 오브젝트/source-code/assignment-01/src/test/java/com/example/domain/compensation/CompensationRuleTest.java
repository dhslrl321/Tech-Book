package com.example.domain.compensation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.example.domain.value.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompensationRuleTest {

    private static final int BASE_HIT_COUNT = 3;
    private static final int DIFFERENT_HIT_COUNT = 1;
    private static final Price REWARD_PRICE = Price.of(1000000);

    CompensationRule sut;

    @BeforeEach
    void setUp() {
        sut = CompensationRule.of(REWARD_PRICE, BASE_HIT_COUNT);
    }

    @Test
    void 보상_정책에_있는_숫자와_같으면_정책에_만족한다() {
        boolean actual = sut.isSatisfiedBy(BASE_HIT_COUNT);

        assertThat(actual).isEqualTo(true);
    }

    @Test
    void 보상_정책에_있는_숫자와_다르면_정책에_만족하지_않는다() {
        boolean actual = sut.isSatisfiedBy(DIFFERENT_HIT_COUNT);

        assertThat(actual).isEqualTo(false);
    }

    @Test
    void 보상에_해당하는_누적_수를_조회한다() {
        sut.plusActualCount();
        int count = sut.getActualCount();

        assertThat(count).isEqualTo(1);
    }

    @Test
    void Compensation_으로_변환한다() {
        sut.plusActualCount();
        sut.plusActualCount();
        Compensation actual = sut.toCompensation();

        assertThat(actual.getRewardPrice()).isEqualTo(REWARD_PRICE);
        assertThat(actual.getBaseCount()).isEqualTo(BASE_HIT_COUNT);
        assertThat(actual.getActualCount()).isEqualTo(2);
    }
}