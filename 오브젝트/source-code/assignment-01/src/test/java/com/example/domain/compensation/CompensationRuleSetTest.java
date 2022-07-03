package com.example.domain.compensation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompensationRuleSetTest {

    CompensationRuleSet sut;

    CompensationRule rule1;
    CompensationRule rule2;
    CompensationRule rule3;

    @BeforeEach
    void setUp() {
        addMockRules();
        sut = CompensationRuleSet.empty();
        stubbingMockRule();
    }

    @Test
    void 룰을_추가할_수_있다() {
        assertThat(sut.getRuleSize()).isEqualTo(3);
    }

    @Test
    void 룰에_만족하는_보상을_증가한다() {
        List<Integer> hits = getHits();

        given(rule1.isSatisfiedBy(3)).willReturn(true);
        given(rule2.isSatisfiedBy(4)).willReturn(true);

        sut.counting(hits);

        verify(rule1).plusActualCount();
        verify(rule2).plusActualCount();
    }

    @Test
    void 룰을_보상으로_변환한다() {
        Compensations actual = sut.toCompensations();

        assertThat(actual.size()).isEqualTo(3);
    }

    private List<Integer> getHits() {
        List<Integer> hits = new ArrayList<>();
        hits.add(1);
        hits.add(3);
        hits.add(4);
        return hits;
    }

    private void addMockRules() {
        rule1 = mock(CompensationRule.class);
        rule2 = mock(CompensationRule.class);
        rule3 = mock(CompensationRule.class);
    }

    private void stubbingMockRule() {
        sut.addRule(rule1);
        sut.addRule(rule2);
        sut.addRule(rule3);
    }
}