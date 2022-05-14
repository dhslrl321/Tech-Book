package com.example.advanced.specification;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConditionTest {

    Condition<SomeFactor> adultCondition = f -> f.getAge() > 18;
    Condition<SomeFactor> songNameCondition = f -> f.getName().startsWith("송");

    @Test
    void 나이는_20세_이상이어야_한다() {
        SomeFactor factor = new SomeFactor(20, "장원익");

        boolean actual = adultCondition.isSatisfy(factor);
        assertThat(actual).isTrue();
    }

    @Test
    void 이름이_송씨라면_참이다() {
        SomeFactor factor = new SomeFactor(20, "송태기");

        boolean actual = songNameCondition.isSatisfy(factor);
        assertThat(actual).isTrue();
    }

    @Test
    void 이름이_장씨라면_거짓이다() {
        SomeFactor factor = new SomeFactor(20, "장원익");

        boolean actual = songNameCondition.isSatisfy(factor);
        assertThat(actual).isFalse();
    }

    @Test
    void 이름과_나이의_조합이_가능해야_한다() {
        SomeFactor factor = new SomeFactor(20, "송태기");

        boolean actual = adultCondition.and(songNameCondition).isSatisfy(factor);
        assertThat(actual).isTrue();
    }
}