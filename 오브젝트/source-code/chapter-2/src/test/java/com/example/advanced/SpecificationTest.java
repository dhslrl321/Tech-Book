package com.example.advanced;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecificationTest {

    Specification<Factor> ageSpec = factor -> factor.getAge() > 19;
    Specification nameSpec = factor -> factor.getName().startsWith("장");

    @BeforeEach
    void setUp() {

    }

    @Test
    void 나이가_19세_이상이라면_참() {
        Factor factor = new Factor(20, "장원익");
        boolean actual = ageSpec.isSatisfiedBy(factor);
        assertThat(actual).isTrue();
    }

    @Test
    void 나이가_19세_이하라면_거짓() {
        Factor factor = new Factor(18, "장원익");
        boolean actual = ageSpec.isSatisfiedBy(factor);
        assertThat(actual).isFalse();
    }

    @Test
    void 이름이_장으로_시작하면_참() {
        Factor factor = new Factor(18, "장원익");
        boolean actual = nameSpec.isSatisfiedBy(factor);
        assertThat(actual).isTrue();
    }

    @Test
    void 이름이_장이면서_18살_이하() {
        Factor factor = new Factor(18, "장원익");
        Specification compositeSpec = nameSpec.and(ageSpec);
        boolean actual = compositeSpec.isSatisfiedBy(factor);

        assertThat(actual).isFalse();
    }
}